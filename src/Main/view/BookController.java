/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.view;

import Main.Main;
import entity.Book;
import entity.Category;
import entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.BookService;
import service.CategoryService;
import service.UserService;
import Util.WebScraper;
<<<<<<< HEAD
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import piamine.AcceuilController;
import static piamine.AcceuilEleveController.id_user;
=======
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028

/**
 * FXML Controller class
 *
 * @author Aoe Neko 98
 */
public class BookController {

    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> bookNameColumn;
    @FXML
    private TableColumn<Book, String> bookTypeColumn;
    @FXML
    private TableColumn<Book, String> bookUserColumn;

<<<<<<< HEAD
=======
    @FXML
    private ListView simi;
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028

    @FXML
    private Label isbnlbl;
    @FXML
    private Label isbnlbl1;
    @FXML
    private Label nameLbl;
    @FXML
    private Label typeLbl;
    @FXML
    private Label descriptionLbl;
    @FXML
    private Label prixLabel;
    @FXML
    private ImageView imgView;
    @FXML
    private TextField searchBook;
    @FXML
    private ComboBox<Category> bookType;
    @FXML
    private Slider price;
    @FXML
    private Label note;

    @FXML
    private ComboBox<String> bookTypes;

    @FXML
    private TableView<Book> bookTable1;
    @FXML
    private TableColumn<Book, String> bookNameColumn1;
    @FXML
    private TableColumn<Book, String> bookTypeColumn1;
    @FXML
    private TableColumn<Book, String> bookUserColumn1;

    @FXML
    private ListView<String> simi1;

    @FXML
    private Label nameLbl1;
    @FXML
    private Label typeLbl1;
    @FXML
    private Label descriptionLbl1;
    @FXML
    private Label prixLabel1;
    @FXML
    private ImageView imgView1;
    @FXML
    private TextField searchBook1;
    @FXML
    private ComboBox<Category> bookType1;
    @FXML
    private Slider price1;
<<<<<<< HEAD
=======
    @FXML
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
    private Button lightBtn;
    @FXML
    private Button darkBtn;
    public static String sta;

    @FXML
    private ComboBox<String> bookTypes1;

    private ObservableList<Book> data;
    private ObservableList<Category> types;
    private ObservableList<User> user;

    private ObservableList<Book> data1;
    private ObservableList<Category> types1;
    private ObservableList<User> user1;

    BookService bs = new BookService();
    CategoryService cs = new CategoryService();
    UserService us = new UserService();
    WebScraper ws = new WebScraper();
    Book b;
    Book d = new Book("9780141349978");

    public void initialize() {
        System.out.println("=========================================================");
        // TODO
<<<<<<< HEAD
        
        List<Book> ls = bs.showAllBooks();
        ArrayList<Category> lsc = cs.getAllCategories();
        ArrayList<User> luc = us.getAllUsers();
        ArrayList<Category> lsc1 = cs.getAllCategories();
        ArrayList<User> luc1 = us.getAllUsers();
=======

        List<Book> ls = bs.showAllBooks();
        ArrayList<Category> lsc = cs.getAllCategories();
        ArrayList<User> luc = us.getAllUsers();
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
        data = FXCollections.observableArrayList();
        types = FXCollections.observableArrayList();
        user = FXCollections.observableArrayList();
        lsc.stream().forEach((j) -> {
            types.add(j);
        });
        ls.stream().forEach((j) -> {
            data.add(j);
        });
        luc.stream().forEach((j) -> {
            user.add(j);
        });

        bookType1.setItems(types);
        ObservableList<String> types2
                = FXCollections.observableArrayList(
                        "Tous",
                        "Vendre",
                        "Echange",
                        "Demande"
                );
        bookTypes1.setItems(types2);

        bookTable1.setItems(data);
        bookNameColumn1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        bookTypeColumn1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory().getNom() + ""));
        bookUserColumn1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUser().getNom() + ""));
<<<<<<< HEAD
        handleReset();
=======

>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
        showBookDetails(null);
        bookTable1.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookDetails(newValue));
        bookTable1.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> handleSim(newValue));
        price1.setMax(bs.maxPrice());

<<<<<<< HEAD
        List<Book> ls1 = bs.showMyBooks(id);
=======
        List<Book> ls1 = bs.showMyBooks();
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028

        data1 = FXCollections.observableArrayList();
        types1 = FXCollections.observableArrayList();
        user1 = FXCollections.observableArrayList();
<<<<<<< HEAD
        ls1.stream().forEach((j) -> {
            data1.add(j);
        });
        lsc1.stream().forEach((j) -> {
            types1.add(j);
        });
        
        luc1.stream().forEach((j) -> {
=======
        lsc.stream().forEach((j) -> {
            types1.add(j);
        });
        ls1.stream().forEach((j) -> {
            data1.add(j);
        });
        luc.stream().forEach((j) -> {
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
            user1.add(j);
        });

        bookType.setItems(types1);

        bookTypes.setItems(types2);

        bookTable.setItems(data1);
<<<<<<< HEAD
        System.out.println(data1);
        bookNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()+""));
=======
        bookNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
        bookTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory().getNom() + ""));
        bookUserColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUser().getNom() + ""));
        // ListeView.setCellFactory((ListView<ProduitHerbo> param) -> new ListViewPHerboItemCell());
        showBookDetails(null);
        showMyBookDetails(null);
        bookTable1.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookDetails(newValue));
        bookTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMyBookDetails(newValue));
        bookTable1.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> handleSim(newValue));
//        bookTable1.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> viewNote(newValue));
        price.setMax(bs.maxPrice());

    }

    public void showBookDetails(Book p) {
        if (p != null) {
            nameLbl1.setText(p.getNom());
            descriptionLbl1.setText(p.getDiscreption());
            typeLbl1.setText(p.getType());
            prixLabel1.setText(p.getPrix() + "");
            isbnlbl.setText(p.getIsbn());
<<<<<<< HEAD
            Image image = new Image("http://localhost:7882/appJava/" + p.getImage());
=======
            Image image = new Image("http://localhost/appJava/" + p.getImage());
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
            imgView1.setImage(image);
            viewNote(p);
        } else {
            nameLbl1.setText("");
            descriptionLbl1.setText("");
            typeLbl1.setText("");
            prixLabel1.setText("");
            isbnlbl.setText("");
            note.setText("");
            //imgLabel.setText("");
        }

    }

    public void showMyBookDetails(Book p) {

        if (p != null) {
            nameLbl.setText(p.getNom());
            descriptionLbl.setText(p.getDiscreption());
            typeLbl.setText(p.getType());
            isbnlbl1.setText(p.getIsbn());
            prixLabel.setText(p.getPrix() + "");
<<<<<<< HEAD
            Image image = new Image("http://localhost:7882/appJava/" + p.getImage());
=======
            Image image = new Image("http://localhost/appJava/" + p.getImage());
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
            imgView.setImage(image);
        } else {
            nameLbl.setText("");
            descriptionLbl.setText("");
            typeLbl.setText("");
            prixLabel.setText("");
            isbnlbl1.setText("");
            //imgLabel.setText("");
        }

    }

    @FXML
    private void handleDeleteBook() {
        int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Dialog");
        a.setHeaderText("Really ?");
        a.setContentText("Are you ok with this?");

        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == ButtonType.OK) {
            if (selectedIndex >= 0) {
                bookTable.getItems().remove(selectedIndex);
                bs.deleteBook(selectedBook);
            } else {
                // Nothing selected.
                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("No Selection");
                alert.setHeaderText("No Book Selected");
                alert.setContentText("Please select a Book in the table.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void handleAddBook() {
        Book book = new Book();
        boolean okClicked = showBookEditDialog(book);
        System.out.println(okClicked);
        if (okClicked) {
            bs.addBook(book);
            initialize();
        }

    }

    @FXML
    private void handleEditBook() {

        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            boolean okClicked = showBookEditDialog(selectedBook);
            if (okClicked) {
                showBookDetails(selectedBook);
                bs.editBook(selectedBook);
                initialize();
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            ////alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Book Selected");
            alert.setContentText("Please select a book in the table.");

            alert.showAndWait();

        }
    }
<<<<<<< HEAD
 public static int id;
    public void setid(int y){
        id=y;
    }
=======

>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
    public boolean showBookEditDialog(Book book) {
        try {
            if (sta == "Dark") {
                FXMLLoader loader2 = new FXMLLoader();
                loader2.setLocation(Main.class.getResource("view/BookEditDialog.fxml"));
<<<<<<< HEAD
                 BookEditDialogController cc = loader2.getController();
                 System.out.println(id);
               
                 
                
=======
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
                // Create the dialog Stage.
                Stage dialogStage = new Stage();
                StackPane page = (StackPane) loader2.load();
                dialogStage.setTitle("Edit book");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                // dialogStage.initOwner(primaryStage);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                // Set the person into the controller.
                BookEditDialogController controller = loader2.getController();
                controller.setDialogStage(dialogStage);
                controller.setBook(book);
                // Show the dialog and wait until the user closes it
                dialogStage.showAndWait();
                return controller.isOkClicked();
            } else {
                FXMLLoader loader2 = new FXMLLoader();
                loader2.setLocation(Main.class.getResource("view/BookEditDialog_1.fxml"));
<<<<<<< HEAD
                BookEditDialogController cc = loader2.getController();
                 System.out.println(id);
               
=======
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
                // Create the dialog Stage.
                Stage dialogStage = new Stage();
                StackPane page = (StackPane) loader2.load();
                dialogStage.setTitle("Edit book");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                // dialogStage.initOwner(primaryStage);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                // Set the person into the controller.
                BookEditDialogController controller = loader2.getController();
                controller.setDialogStage(dialogStage);
                controller.setBook(book);
                // Show the dialog and wait until the user closes it
                dialogStage.showAndWait();
                return controller.isOkClicked();

            }
        } catch (IOException e) {
<<<<<<< HEAD
            System.out.println(e);
        return false;   
        }
        
=======
            System.err.println(e.toString());
            return false;
        }
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
    }

    @FXML
    private void handleSearchBook() {
        String txt = searchBook1.getText();
        Category cate = bookType1.getValue();
        String t = new String();
        float p = (float) price1.getValue();

        System.out.println(txt);
        System.out.println(cate);
        System.out.println(p);
        data = FXCollections.observableArrayList();
        String test = bookTypes1.getSelectionModel().getSelectedItem();
        try {
            if (test.equals("Tous")) {
                t = "";
            } else {
                t = test;

            }
        } catch (Exception e) {
            t = "";
        }

        List<Book> lsc = bs.searchBookByName(txt, cate, t, p);
        lsc.stream().forEach((j) -> {
            data.add(j);
        });
        bookTable1.setItems(data);
        bookNameColumn1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        bookTypeColumn1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory().getNom()));
        bookUserColumn1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUser().getNom() + ""));

        String txt1 = searchBook.getText();
        Category cate1 = bookType.getValue();
        String t1 = new String();
        float p1 = (float) price.getValue();

        data1 = FXCollections.observableArrayList();
        String test1 = bookTypes.getSelectionModel().getSelectedItem();
        try {
            if (test1.equals("Tous")) {
                t1 = "";
            } else {
                t1 = test1;

            }
        } catch (Exception e) {
            t1 = "";
        }

        List<Book> lsc1 = bs.searchMyBookByName(txt1, cate1, t1, p1);
        lsc1.stream().forEach((j) -> {
            data1.add(j);
        });
        bookTable.setItems(data1);
        bookNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        bookTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory().getNom()));
        bookUserColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUser().getNom() + ""));

    }

    @FXML
    private void handleReset() {
        bookType1.getSelectionModel().clearSelection();
        bookTypes1.setValue("Tous");
        //  System.out.println(bookType.getValue());
        price1.setValue(0);
        bookType.getSelectionModel().clearSelection();
        bookTypes.setValue("Tous");
        //  System.out.println(bookType.getValue());
        price.setValue(0);

        initialize();

    }

    private void handleSim(Book t) {

        int i;
        Integer value;
        ArrayList<String> list = new ArrayList<>();
        Map<String, Integer> s = bs.similaire(t.getNom());
        String key;
        for (Map.Entry<String, Integer> entry : s.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();

            if (value != 0 && value < key.length()) {
                list.add(key);
            }
        }
        simi1.getItems().clear();
        for (i = 0; i <= 2 && i < list.size(); i++) {

            simi1.getItems().add(list.get(i));
        }

    }

    @FXML
    private void handleDark() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("bib.fxml"));
            sta = "Dark";

            Stage stage1 = (Stage) darkBtn.getScene().getWindow();

            stage1.close();
            Scene scene = new Scene(fxmlLoader.load(), 1600, 900);
            Stage stage = new Stage();
            stage.setTitle("Dark");
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }

<<<<<<< HEAD
=======
    @FXML
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
    private void handleLight() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("bib_1.fxml"));
            sta = "light";

            Stage stage1 = (Stage) lightBtn.getScene().getWindow();

            stage1.close();
            Scene scene = new Scene(fxmlLoader.load(), 1600, 900);
            Stage stage = new Stage();
            stage.setTitle("Light");

            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }

    public void viewNote(Book p)  {

        if (p != null) {
            ws.webScrapper(p, note);

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            ////alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Book Selected");
            alert.setContentText("Please select a book in the table.");
            note.setText("");

            alert.showAndWait();

        }

    }

<<<<<<< HEAD
    @FXML
    private void Retour(ActionEvent event) throws IOException, SQLException {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("/piamine/acceuil.fxml"));
                Parent Ajouter = (Parent)loader.load();    
                Scene scene = new Scene(Ajouter);
                AcceuilController e=loader.getController();
               
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }

=======
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
}
