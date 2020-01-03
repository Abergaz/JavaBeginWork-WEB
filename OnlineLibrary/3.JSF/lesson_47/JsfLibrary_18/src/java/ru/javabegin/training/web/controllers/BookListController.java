package ru.javabegin.training.web.controllers;

import java.io.Serializable;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.PrimeFaces;
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.model.LazyDataModel;
import ru.javabegin.training.web.beans.Pager;
import ru.javabegin.training.web.db.DataHelper;
import ru.javabegin.training.web.entity.Book;
import ru.javabegin.training.web.enums.SearchType;
import ru.javabegin.training.web.models.BookListDataModel;

@ManagedBean(eager = true)
@SessionScoped
public class BookListController implements Serializable {

    private Book selectedBook;
    private DataHelper dataHelper = dataHelper = DataHelper.getInstance();
    private LazyDataModel<Book> bookListModel;
    private Long selectedAuthorId;// текущий автор книги из списка при редактировании книги
    // критерии поиска
    private char selectedLetter; // выбранная буква алфавита, по умолчанию не выбрана ни одна буква
    private SearchType selectedSearchType = SearchType.TITLE;// хранит выбранный тип поиска, по-умолчанию - по названию
    private long selectedGenreId; // выбранный жанр
    private String currentSearchString; // хранит поисковую строку
    private Pager pager = Pager.getInstance();
    //-------
    private boolean editModeView;// отображение режима редактирования

    public BookListController() {
        bookListModel = new BookListDataModel();
    }

    private void submitValues(Character selectedLetter, long selectedGenreId) {
        this.selectedLetter = selectedLetter;
        this.selectedGenreId = selectedGenreId;
//        dataTable.setFirst(0);
    }

    //<editor-fold defaultstate="collapsed" desc="запросы в базу">
    private void fillBooksAll() {
        dataHelper.getAllBooks();
    }

    public void fillBooksByGenre() {
        
        imitateLoading();

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        selectedGenreId = Long.valueOf(params.get("genre_id"));
        submitValues(' ', selectedGenreId);
        dataHelper.getBooksByGenre(selectedGenreId);

    }

    public void fillBooksByLetter() {
        
        imitateLoading();

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        selectedLetter = params.get("letter").charAt(0);
        submitValues(selectedLetter, -1);
        dataHelper.getBooksByLetter(selectedLetter);

    }

    public void fillBooksBySearch() {
        
        imitateLoading();

        submitValues(' ', -1);

        if (currentSearchString.trim().length() == 0) {
            fillBooksAll();

        }

        if (selectedSearchType == SearchType.AUTHOR) {
            dataHelper.getBooksByAuthor(currentSearchString);
        } else if (selectedSearchType == SearchType.TITLE) {
            dataHelper.getBooksByName(currentSearchString);
        }

    }

    public void updateBook() {

        dataHelper.updateBook(selectedBook);
        cancelEditMode();
        dataHelper.populateList();
        
//        вместо RequestContext.getCurrentInstance().execute в последней версии PrimeFaces теперь нужно использовать PrimeFaces.current().executeScript
//        RequestContext.getCurrentInstance().execute("PF('dlgEditBook').hide()");

        PrimeFaces.current().executeScript("PF('dlgEditBook').hide()");


        ResourceBundle bundle = ResourceBundle.getBundle("ru.javabegin.training.web.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle.getString("updated")));

    }

    public void deleteBook() {
        dataHelper.deleteBook(selectedBook);
        dataHelper.populateList();

//        RequestContext.getCurrentInstance().execute("PF('dlgDeleteBook').hide()");
        ResourceBundle bundle = ResourceBundle.getBundle("ru.javabegin.training.web.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle.getString("deleted")));

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="режим редактирования">
    public void cancelEditMode() {
        editModeView = false;
        
//        вместо RequestContext.getCurrentInstance().execute в последней версии PrimeFaces теперь нужно использовать PrimeFaces.current().executeScript
//        RequestContext.getCurrentInstance().execute("PF('dlgEditBook').hide()");

        PrimeFaces.current().executeScript("PF('dlgEditBook').hide()");
        

    }

    public void switchEditMode() {
        editModeView = true;
        
        //        вместо RequestContext.getCurrentInstance().execute в последней версии PrimeFaces теперь нужно использовать PrimeFaces.current().executeScript
//        RequestContext.getCurrentInstance().execute("PF('dlgEditBook').show()");

        PrimeFaces.current().executeScript("PF('dlgEditBook').show()");
        

    }

    //</editor-fold>
    public Character[] getRussianLetters() {
        Character[] letters = new Character[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',};
        return letters;
    }

    public void searchStringChanged(ValueChangeEvent e) {
        currentSearchString = e.getNewValue().toString();
    }

    public void searchTypeChanged(ValueChangeEvent e) {
        selectedSearchType = (SearchType) e.getNewValue();
    }


    //<editor-fold defaultstate="collapsed" desc="гетеры сетеры">
    public boolean isEditMode() {
        return editModeView;
    }

    public String getSearchString() {
        return currentSearchString;
    }

    public void setSearchString(String searchString) {
        this.currentSearchString = searchString;
    }

    public SearchType getSearchType() {
        return selectedSearchType;
    }

    public void setSearchType(SearchType searchType) {
        this.selectedSearchType = searchType;
    }

    public long getSelectedGenreId() {
        return selectedGenreId;
    }

    public void setSelectedGenreId(int selectedGenreId) {
        this.selectedGenreId = selectedGenreId;
    }

    public char getSelectedLetter() {
        return selectedLetter;
    }

    public void setSelectedLetter(char selectedLetter) {
        this.selectedLetter = selectedLetter;
    }

    public Long getSelectedAuthorId() {
        return selectedAuthorId;
    }

    public void setSelectedAuthorId(Long selectedAuthorId) {
        this.selectedAuthorId = selectedAuthorId;
    }

    public Pager getPager() {
        return pager;
    }

    public LazyDataModel<Book> getBookListModel() {
        return bookListModel;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    //</editor-fold>

    private void imitateLoading() {
        try {
            Thread.sleep(1000);// имитация загрузки процесса
        } catch (InterruptedException ex) {
            Logger.getLogger(BookListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
