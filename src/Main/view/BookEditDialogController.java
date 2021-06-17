/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.view;

<<<<<<< HEAD
import static Main.view.BookController.id;
=======
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
import Util.PostFile;
import entity.Book;
import entity.Category;
import entity.User;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.BookService;
import service.CategoryService;

/**
 *
 * @author Aoe Neko 98
 */
public class BookEditDialogController {

    @FXML
    private TextField NameField;
    @FXML
    private TextField IsbnField;
    @FXML
    private ComboBox<Category> TypeField;
    @FXML
    private ComboBox<String> types2Field;
    @FXML
    private TextField DiscretionField;
    @FXML
    private TextField PrixField;
<<<<<<< HEAD
=======
    @FXML
    private TextField ImageField;
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028

    private Stage dialogStage;
    private Book book;
    private boolean okClicked = false;
    private File f;
    @FXML
    private ImageView img;
   

    private BookService bs = new BookService();
    CategoryService cs = new CategoryService();
    private ObservableList<Category> types;
    private User user =new User();
   

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        
        
        types = FXCollections.observableArrayList();
        ArrayList<Category> lsc = cs.getAllCategories();
        lsc.stream().forEach((j) -> {
            types.add(j);
        });
        TypeField.setItems(types);
           ObservableList<String> types2 = 
    FXCollections.observableArrayList(
        "Tous",
        "Vendre",
        "Echange",
        "Demande"
    );
           types2Field.setItems(types2);
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() throws Exception {

        book.setNom(NameField.getText());
        book.setCategory(TypeField.getValue());  
        book.setDiscreption(DiscretionField.getText());
<<<<<<< HEAD
       
=======
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
        
        try {
            book.setPrix(Float.parseFloat(PrixField.getText()));
        } catch (NumberFormatException exception) {
            book.setPrix(0);
        }
        if (f.getName().length()> 0) {
            book.setImage(PostFile.upload(f.getAbsolutePath()));
        }
        book.setType(types2Field.getValue());
        book.setIsbn(IsbnField.getText());
        System.out.println("boook : " + book.getId());
        bs.editBook(book);
        okClicked = true;
        System.out.println(okClicked);
        dialogStage.close();

    }
<<<<<<< HEAD
   
=======

>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public void setBook(Book book) {
        this.book = book;

        NameField.setText(book.getNom());
        TypeField.setValue(book.getCategory());
        DiscretionField.setText(book.getDiscreption());
        //ImageField.setText(book.getImage());
        PrixField.setText(book.getPrix() + "");
        types2Field.setValue(book.getType());
        IsbnField.setText(book.getIsbn());
        

    }

<<<<<<< HEAD
    @FXML
=======
>>>>>>> bbe37c878253ac63f653aff063c98b5a402e9028
    public void uploadPhoto() throws MalformedURLException, Exception {
        FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(imageFilter);
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            String imageFile = selectedFile.toURI().toURL().toString();
            this.f = selectedFile;
            System.out.println(imageFile);
            System.out.println(selectedFile.getAbsolutePath());
            //PostFile.upload(selectedFile.getAbsolutePath());         
            Image image = new Image(imageFile);
            img.setImage(image);
            book.setImage(selectedFile.getName());
        }
    }
    

}
