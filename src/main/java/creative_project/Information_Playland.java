package creative_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import persistence.MyBatisConnectionFactory;
import persistence.dao.playlandDAO;
import persistence.dto.playLandDTO;

import java.io.IOException;
import java.util.List;

public class Information_Playland {

    @FXML
    private Parent parent;

    @FXML
    private User_Main parentController;

    @FXML
    private Button btn_search_playland;

    @FXML
    private Button btn_search_playland2;

    @FXML
    private MenuButton mb_information_Do;

    @FXML
    private MenuButton mb_information_Si;

    @FXML
    private TableColumn<?, ?> tc_playland_address;

    @FXML
    private TableColumn<?, ?> tc_playland_name;

    @FXML
    private TableColumn<?, ?> tc_playland_review;

    @FXML
    private TableColumn<?, ?> tc_playland_score;

    @FXML
    private TableColumn<?, ?> tc_playland_sort;

    @FXML
    private TextField tf_search_playland;

    @FXML
    private TableColumn<?, ?> tv_playland_review;
    @FXML
    private TableView<playLandDTO> tv_information_playland;


    @FXML
    void view_search_playland(ActionEvent event) {
        playlandDAO playlandDAO = new playlandDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        List<playLandDTO> playlands = playlandDAO.showPlayLand();
        ObservableList<playLandDTO> observablePlaylands = FXCollections.observableArrayList(playlands);

        tc_playland_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tc_playland_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        // tc_playland_review.setCellValueFactory(new PropertyValueFactory<>("review"));
        tc_playland_score.setCellValueFactory(new PropertyValueFactory<>("score"));
        // tc_playland_sort.setCellValueFactory(new PropertyValueFactory<>("sort"));

        tv_information_playland.setItems(observablePlaylands);
    }


}
