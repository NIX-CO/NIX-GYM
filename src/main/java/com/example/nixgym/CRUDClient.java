package com.example.nixgym;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.*;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.scene.input.MouseEvent;

        import java.sql.*;
        import java.time.LocalDate;

public class CRUDClient {

    @FXML
    private Label Cabel;

    @FXML
    private Button CltBtnAjouter;

    @FXML
    private Button CltBtnModifier;

    @FXML
    private Button CltBtnSupprimer;

    @FXML
    private TextField CltEmailInput;

    @FXML
    private ComboBox<Integer> CltIsActiveCombo;

    @FXML
    private TextField CltNomInput;

    @FXML
    private TextField CltPrenomInput;

    @FXML
    private TableView<Client> CltTableView;

    @FXML
    private TableColumn<Client, String> CltTableViewColEmail;

    @FXML
    private TableColumn<Client, Integer> CltTableViewColID;

    @FXML
    private TableColumn<Client, Integer> CltTableViewColIsActive;

    @FXML
    private TableColumn<Client, String> CltTableViewColNom;

    @FXML
    private TableColumn<Client, String> CltTableViewColPrenom;

    @FXML
    private Button CoaBtnAjouter;

    @FXML
    private Button CoaBtnModifier;

    @FXML
    private Button CoaBtnSupprimer;

    @FXML
    private TextField CoaEmailInput;

    @FXML
    private ComboBox<Integer> CoaIsActiveCombo;

    @FXML
    private TextField CoaNomInput;

    @FXML
    private PasswordField CoaPassWordInput;

    @FXML
    private TextField CoaPrenomInput;

    @FXML
    private TableView<Coach> CoaTableView;

    @FXML
    private TableColumn<Coach, String> CoaTableViewColEmail;

    @FXML
    private TableColumn<Coach, Integer> CoaTableViewColID;

    @FXML
    private TableColumn<Coach, Integer> CoaTableViewColIsActive;

    @FXML
    private TableColumn<Coach, String> CoaTableViewColNom;

    @FXML
    private TableColumn<Coach, String> CoaTableViewColPrenom;

    @FXML
    private TableColumn<Coach, String> CoaTableViewColUsername;

    @FXML
    private TextField CoaUsernameInput;

    @FXML
    private Label Coabel;

    @FXML
    private Button MatBtnAjout;

    @FXML
    private TextField MatNameInput;

    @FXML
    private TextField MatRefInput;

    @FXML
    private ComboBox<String> MatStatusCombo;

    @FXML
    private TableView<Materiel> MatTableView;

    @FXML
    private TableColumn<Materiel, String> MatTableViewColName;

    @FXML
    private TableColumn<Materiel, String> MatTableViewColStatus;

    @FXML
    private TableColumn<Materiel, String> MatTableViewColType;

    @FXML
    private TableColumn<Materiel, String> MatTableViewColRef;

    @FXML
    private ComboBox<String> MatTypeCombo;

    @FXML
    private Button PlnBtnAjouter;

    @FXML
    private Button PlnBtnModifier;

    @FXML
    private Button PlnBtnSupprimer;

    @FXML
    private ComboBox<String> PlnCoachCombo;

    @FXML
    private DatePicker PlnDateInput;

    @FXML
    private TextField PlnHeureDebut;

    @FXML
    private TextField PlnHeureFin;

    @FXML
    private TableView<Plan> PlnTableView;

    @FXML
    private TableColumn<Plan, Date> PnlTableViewColDate;

    @FXML
    private TableColumn<Plan, String> PnlTableViewColHeureDebut;

    @FXML
    private TableColumn<Plan, String> PnlTableViewColHeureFin;

    @FXML
    private TableColumn<Plan, String> PnlTableViewColCoach;

    @FXML
    private TableColumn<Plan, Integer> PnlTableViewColID;

    @FXML
    private Tab TabClient;

    @FXML
    private Tab TabMatriel;

    @FXML
    private Label lavel;

    @FXML
    private Tab TabPlan;

    @FXML
    private Button btnClient;

    @FXML
    private Button btnMateriel;

    @FXML
    private Button btnPlan;

    @FXML
    private Button btnCoach;

    @FXML
    private TabPane tabPane;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;

    @FXML
    public void initialize() {
        ObservableList<String> ListeMatType = FXCollections.observableArrayList("Cardio","Claves","Biceps");
        MatTypeCombo.setItems(ListeMatType);

        ObservableList<String> ListeMatStatus = FXCollections.observableArrayList("Active","Not Active","Reparaton");
        MatStatusCombo.setItems(ListeMatStatus);

        ObservableList<Integer> ListeCltIsActive = FXCollections.observableArrayList(0,1);
        CltIsActiveCombo.setItems(ListeCltIsActive);
        CoaIsActiveCombo.setItems(ListeCltIsActive);

        llenadocombobox();

        showAllMateriel();
        showAllClients();
        showAllCoaches();
        showAllPlan();
    }

    public void llenadocombobox() {
        try {
            con=DBUtil.getConnection();
            ObservableList<String> listacombo= FXCollections.observableArrayList();
            String consulta = "select nom from personne where role like 'Coach' and is_Active=1";
            PreparedStatement ps =con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                listacombo.add(rs.getString("nom"));
            }

            PlnCoachCombo.setItems(listacombo);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void CltBtnAjouterClick(ActionEvent event) {
        AddClient();
    }

    @FXML
    void CltBtnModifierClick(ActionEvent event) {
        updateClients();
    }

    @FXML
    void CltBtnSupprimerClick(ActionEvent event) {
        deleteClient();
    }

    @FXML
    void CltHandelMouseAction(MouseEvent event) {
        Client clt = CltTableView.getSelectionModel().getSelectedItem();
        CltNomInput.setText(clt.getNom());
        CltPrenomInput.setText(clt.getPrenom());
        CltEmailInput.setText(clt.getEmail());
        CltIsActiveCombo.setValue(clt.getIsActive());
    }

    @FXML
    void CoaBtnAjouterClick(ActionEvent event) {
        AddCoach();
    }

    @FXML
    void CoaBtnModifierClick(ActionEvent event) {
        updateCoaches();
    }

    @FXML
    void CoaBtnSupprimerClick(ActionEvent event) {
        deleteCoaches();
    }

    @FXML
    void CoaHandelMouseAction(MouseEvent event) {
        Coach coa = CoaTableView.getSelectionModel().getSelectedItem();
        CoaUsernameInput.setText(coa.getUsername());
        CoaPassWordInput.setText(coa.getPassWd());
        CoaNomInput.setText(coa.getNom());
        CoaPrenomInput.setText(coa.getPrenom());
        CoaEmailInput.setText(coa.getEmail());
        CoaIsActiveCombo.setValue(coa.getIsActive());
    }


    @FXML
    void MatBtnAjoutClick(ActionEvent event) {
        AddMateriel();
    }
    @FXML
    void MatBtnModifierClick(ActionEvent event) {
        updateMateriel();
    }

    @FXML
    void MatBtnSupprimerClick(ActionEvent actionEvent) {
        deleteMateriel();
    }

    @FXML
    void btnClientClick(ActionEvent event) {
        tabPane.getSelectionModel().select(0);
    }

    @FXML
    void btnMaterielClick(ActionEvent event) {
        tabPane.getSelectionModel().select(1);
    }

    @FXML
    void btnPlanClick(ActionEvent event) {
        tabPane.getSelectionModel().select(2);
    }

    @FXML
    void btnCoachClick(ActionEvent event) {
        tabPane.getSelectionModel().select(3);
    }

    @FXML
    void MatHandelMouseAction(MouseEvent mouseEvent) {
        Materiel mat = MatTableView.getSelectionModel().getSelectedItem();
        MatRefInput.setText(mat.getReference());
        MatNameInput.setText(mat.getName());
        MatTypeCombo.setValue(mat.getType());
        MatStatusCombo.setValue(mat.getStatus());
    }

    @FXML
    void PlnBtnAjouterClick(ActionEvent event) {
        AddPlan();
    }

    @FXML
    void PlnBtnModifierClick(ActionEvent event) {
        updatePlan();
    }

    @FXML
    void PlnBtnSupprimerClick(ActionEvent event) {
        deletePlan();
    }

    @FXML
    void PlnHandelMouseAction(MouseEvent event) {
        Plan pln = PlnTableView.getSelectionModel().getSelectedItem();
        //PlnDateInput.setValue(pln.getDate());
        PlnHeureDebut.setText(pln.getHeureDebut());
        PlnHeureFin.setText(pln.heureFin);
        PlnCoachCombo.setValue(pln.getCoach());
    }

    Client clt;

    public void AddClient(){

        clt=new Client();
        clt.setNom(CltNomInput.getText());
        clt.setPrenom(CltPrenomInput.getText());
        clt.setEmail(CltEmailInput.getText());
        clt.setRole("Client");
        clt.setIsActive(CltIsActiveCombo.getValue());

        if(clt.getNom().length()==0){
            Cabel.setText("please enter name");
            return;
        }
        try {
            con=DBUtil.getConnection();
            String sql="insert into personne values(0,0,0,?,?,?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,clt.getNom());
            pstmt.setString(2,clt.getPrenom());
            pstmt.setString(3,clt.getEmail());
            pstmt.setString(4,clt.getRole());
            pstmt.setInt(5,clt.getIsActive());
            pstmt.executeUpdate();
            Cabel.setText("Register Sucessfully.");
            showAllClients();
            if(rs.next()){
                CltTableViewColID.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
                CltTableViewColNom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
                CltTableViewColPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
                CltTableViewColEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
                CltTableViewColIsActive.setCellValueFactory(new PropertyValueFactory<Client, Integer>("isActive"));
                ObservableList<Client> data = FXCollections.observableArrayList(
                        new Client(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("is_Active"))
                );
                CltTableView.getItems().addAll(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllClients(){
        try {
            CltTableView.getItems().clear();
            con =DBUtil.getConnection();
            String sql="select * from personne where role like 'Client'";
            pstmt=con.prepareStatement(sql);

            rs=pstmt.executeQuery();
            while(rs.next()){
                CltTableViewColID.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
                CltTableViewColNom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
                CltTableViewColPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
                CltTableViewColEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
                CltTableViewColIsActive.setCellValueFactory(new PropertyValueFactory<Client, Integer>("isActive"));
                ObservableList<Client> data = FXCollections.observableArrayList(
                        new Client(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("is_Active"))
                );
                CltTableView.getItems().addAll(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClients(){
        clt=new Client();
        clt.setNom(CltNomInput.getText());
        clt.setPrenom(CltPrenomInput.getText());
        clt.setEmail(CltEmailInput.getText());
        clt.setIsActive(CltIsActiveCombo.getValue());

        if(clt.getNom().length()==0){
            Cabel.setText("please enter name");
            return;
        }

        try {
            con=DBUtil.getConnection();
            String sql="update personne set nom=?,prenom=?,email=?,is_Active=? where id in (SELECT id from personne WHERE prenom like ?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,clt.getNom());
            pstmt.setString(2,clt.getPrenom());
            pstmt.setString(3,clt.getEmail());
            pstmt.setInt(4,clt.getIsActive());
            pstmt.setString(5,clt.getPrenom());
            pstmt.executeUpdate();
            Cabel.setText("Update Sucessfully.");
            showAllClients();
            if(rs.next()){
                Cabel.setText("Update Sucessfully.");
                CltTableViewColID.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
                CltTableViewColNom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
                CltTableViewColPrenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
                CltTableViewColEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
                CltTableViewColIsActive.setCellValueFactory(new PropertyValueFactory<Client, Integer>("isActive"));
                ObservableList<Client> data = FXCollections.observableArrayList(
                        new Client(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("is_Active"))
                );
                CltTableView.getItems().addAll(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(){
        clt=new Client();
        clt.setNom(CltNomInput.getText());
        clt.setPrenom(CltPrenomInput.getText());
        clt.setEmail(CltEmailInput.getText());
        clt.setIsActive(CltIsActiveCombo.getValue());

        try {
            con =DBUtil.getConnection();
            String sql="delete from personne where email=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, clt.getEmail());
            pstmt.executeUpdate();
            Cabel.setText("Record deleted ");
            showAllClients();
            if(rs!=null){
                lavel.setText("Record deleted ");
            }else{
                lavel.setText("please check employee id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    Materiel mat;

    public void AddMateriel(){

        mat=new Materiel();
        mat.setReference(MatRefInput.getText());
        mat.setName(MatNameInput.getText());
        mat.setType((String) MatTypeCombo.getValue());
        mat.setStatus((String) MatStatusCombo.getValue());

        if(mat.getName().length()==0){
            lavel.setText("please enter name");
            return;
        }
        try {
            con=DBUtil.getConnection();
            String sql="insert into materiel values(?,?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,mat.getReference());
            pstmt.setString(2,mat.getName());
            pstmt.setString(3,mat.getType());
            pstmt.setString(4,mat.getStatus());
            pstmt.executeUpdate();
            lavel.setText("Register Sucessfully.");
            showAllMateriel();
            if(rs.next()){
                lavel.setText("Register Sucessfully.");
                MatTableViewColRef.setCellValueFactory(new PropertyValueFactory<Materiel, String>("reference"));
                MatTableViewColName.setCellValueFactory(new PropertyValueFactory<Materiel, String>("name"));
                MatTableViewColStatus.setCellValueFactory(new PropertyValueFactory<Materiel, String>("status"));
                MatTableViewColType.setCellValueFactory(new PropertyValueFactory<Materiel, String>("type"));
                ObservableList<Materiel> data = FXCollections.observableArrayList(
                        new Materiel(rs.getString("reference"),rs.getString("name"),rs.getString("type"),rs.getString("status"))
                );

                MatTableView.getItems().addAll(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllMateriel(){
        try {
            MatTableView.getItems().clear();
            con =DBUtil.getConnection();
            String sql="select * from Materiel";
            pstmt=con.prepareStatement(sql);

            rs=pstmt.executeQuery();
            while(rs.next()){
                MatTableViewColRef.setCellValueFactory(new PropertyValueFactory<Materiel, String>("reference"));
                MatTableViewColName.setCellValueFactory(new PropertyValueFactory<Materiel, String>("name"));
                MatTableViewColStatus.setCellValueFactory(new PropertyValueFactory<Materiel, String>("status"));
                MatTableViewColType.setCellValueFactory(new PropertyValueFactory<Materiel, String>("type"));
                ObservableList<Materiel> data = FXCollections.observableArrayList(
                        new Materiel(rs.getString("reference"),rs.getString("name"),rs.getString("type"),rs.getString("status"))
                );
                MatTableView.getItems().addAll(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMateriel(){
        mat=new Materiel();
        mat.setReference(MatRefInput.getText());
        mat.setName(MatNameInput.getText());
        mat.setType(MatTypeCombo.getValue());
        mat.setStatus(MatStatusCombo.getValue());

        if(mat.getName().length()<1){
            lavel.setText("please enter name");
            return;
        }

        try {
            con=DBUtil.getConnection();
            String sql="update materiel set name=?,Type=?,Status=? where reference=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,mat.getName());
            pstmt.setString(2,mat.getType());
            pstmt.setString(3,mat.getStatus());
            pstmt.setString(4, mat.getReference());
            pstmt.executeUpdate();
            lavel.setText("Update Sucessfully.");
            showAllMateriel();
            if(rs.next()){
                lavel.setText("Update Sucessfully.");
                MatTableViewColRef.setCellValueFactory(new PropertyValueFactory<Materiel, String>("reference"));
                MatTableViewColName.setCellValueFactory(new PropertyValueFactory<Materiel, String>("name"));
                MatTableViewColStatus.setCellValueFactory(new PropertyValueFactory<Materiel, String>("status"));
                MatTableViewColType.setCellValueFactory(new PropertyValueFactory<Materiel, String>("type"));
                ObservableList<Materiel> data = FXCollections.observableArrayList(
                        new Materiel(rs.getString("reference"),rs.getString("name"),rs.getString("type"),rs.getString("status"))
                );

                MatTableView.getItems().addAll(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void deleteMateriel(){
        mat=new Materiel();
        mat.setReference(MatRefInput.getText());
        mat.setName(MatNameInput.getText());
        mat.setType(MatTypeCombo.getValue());
        mat.setStatus(MatStatusCombo.getValue());

        try {
            con =DBUtil.getConnection();
            String sql="delete from materiel where reference=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, mat.getReference());
            pstmt.executeUpdate();
            lavel.setText("Record deleted ");
            showAllMateriel();
            if(rs!=null){
                lavel.setText("Record deleted ");
            }else{
                lavel.setText("please check employee id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    Coach coa;
    public void AddCoach(){

        coa=new Coach();
        coa.setUsername(CoaUsernameInput.getText());
        coa.setPassWd(CoaPassWordInput.getText());
        coa.setNom(CoaNomInput.getText());
        coa.setPrenom(CoaPrenomInput.getText());
        coa.setEmail(CoaEmailInput.getText());
        coa.setRole("Coach");
        coa.setIsActive((int) CoaIsActiveCombo.getValue());

        if(coa.getNom().length()==0){
            Cabel.setText("please enter name");
            return;
        }
        try {
            con=DBUtil.getConnection();
            String sql="insert into personne values(0,?,?,?,?,?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,coa.getUsername());
            pstmt.setString(2,coa.getPassWd());
            pstmt.setString(3,coa.getNom());
            pstmt.setString(4,coa.getPrenom());
            pstmt.setString(5,coa.getEmail());
            pstmt.setString(6,coa.getRole());
            pstmt.setInt(7,coa.getIsActive());
            pstmt.executeUpdate();
            Cabel.setText("Register Sucessfully.");
            showAllCoaches();
            if(rs.next()){
                CoaTableViewColID.setCellValueFactory(new PropertyValueFactory<Coach, Integer>("id"));
                CoaTableViewColUsername.setCellValueFactory(new PropertyValueFactory<Coach, String>("username"));
                CoaTableViewColNom.setCellValueFactory(new PropertyValueFactory<Coach, String>("nom"));
                CoaTableViewColPrenom.setCellValueFactory(new PropertyValueFactory<Coach, String>("prenom"));
                CoaTableViewColEmail.setCellValueFactory(new PropertyValueFactory<Coach, String>("email"));
                CoaTableViewColIsActive.setCellValueFactory(new PropertyValueFactory<Coach, Integer>("isActive"));
                ObservableList<Coach> data = FXCollections.observableArrayList(
                        new Coach(rs.getInt("id"),rs.getString("username"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("is_Active"))
                );
                CoaTableView.getItems().addAll(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllCoaches(){
        try {
            CoaTableView.getItems().clear();
            con =DBUtil.getConnection();
            String sql="select * from personne where role like 'Coach'";
            pstmt=con.prepareStatement(sql);

            rs=pstmt.executeQuery();
            while(rs.next()){
                CoaTableViewColID.setCellValueFactory(new PropertyValueFactory<Coach, Integer>("id"));
                CoaTableViewColNom.setCellValueFactory(new PropertyValueFactory<Coach, String>("nom"));
                CoaTableViewColPrenom.setCellValueFactory(new PropertyValueFactory<Coach, String>("prenom"));
                CoaTableViewColEmail.setCellValueFactory(new PropertyValueFactory<Coach, String>("email"));
                CoaTableViewColIsActive.setCellValueFactory(new PropertyValueFactory<Coach, Integer>("isActive"));
                CoaTableViewColUsername.setCellValueFactory(new PropertyValueFactory<Coach, String>("username"));
                ObservableList<Coach> data = FXCollections.observableArrayList(
                        new Coach(rs.getInt("id"),rs.getString("username"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("is_Active"))
                );
                CoaTableView.getItems().addAll(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCoaches(){
        coa=new Coach();
        coa.setUsername(CoaUsernameInput.getText());
        coa.setPassWd(CoaPassWordInput.getText());
        coa.setNom(CoaNomInput.getText());
        coa.setPrenom(CoaPrenomInput.getText());
        coa.setEmail(CoaEmailInput.getText());
        coa.setIsActive(CoaIsActiveCombo.getValue());

        if(coa.getNom().length()==0){
            Coabel.setText("please enter name");
            return;
        }

        try {
            con=DBUtil.getConnection();
            String sql="update personne set username=?,password=?,nom=?,prenom=?,email=?,is_Active=? where role like 'Coach' and id in (SELECT id from personne WHERE prenom like ?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,coa.getUsername());
            pstmt.setString(2,coa.getPassWd());
            pstmt.setString(3,coa.getNom());
            pstmt.setString(4,coa.getPrenom());
            pstmt.setString(5,coa.getEmail());
            pstmt.setInt(6,coa.getIsActive());
            pstmt.setString(7,coa.getPrenom());
            pstmt.executeUpdate();
            Cabel.setText("Update Sucessfully.");
            showAllCoaches();
            if(rs.next()){
                Cabel.setText("Update Sucessfully.");
                CoaTableViewColID.setCellValueFactory(new PropertyValueFactory<Coach, Integer>("id"));
                CoaTableViewColNom.setCellValueFactory(new PropertyValueFactory<Coach, String>("nom"));
                CoaTableViewColPrenom.setCellValueFactory(new PropertyValueFactory<Coach, String>("prenom"));
                CoaTableViewColEmail.setCellValueFactory(new PropertyValueFactory<Coach, String>("email"));
                CoaTableViewColIsActive.setCellValueFactory(new PropertyValueFactory<Coach, Integer>("isActive"));
                CoaTableViewColUsername.setCellValueFactory(new PropertyValueFactory<Coach, String>("username"));
                ObservableList<Coach> data = FXCollections.observableArrayList(
                        new Coach(rs.getInt("id"),rs.getString("username"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("is_Active"))
                );
                CoaTableView.getItems().addAll(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCoaches(){
        coa=new Coach();
        coa.setNom(CltNomInput.getText());
        coa.setPrenom(CoaPrenomInput.getText());
        coa.setEmail(CoaEmailInput.getText());
        coa.setIsActive(CoaIsActiveCombo.getValue());

        try {
            con =DBUtil.getConnection();
            String sql="delete from personne where role like 'Coach' and email=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, coa.getEmail());
            pstmt.executeUpdate();
            Cabel.setText("Record deleted ");
            showAllCoaches();
            if(rs!=null){
                lavel.setText("Record deleted ");
            }else{
                lavel.setText("please check employee id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    Plan pln;
    public void AddPlan(){

        pln=new Plan();
        pln.setDate(Date.valueOf(PlnDateInput.getValue()));
        pln.setHeureDebut(PlnHeureDebut.getText());
        pln.setHeureFin(PlnHeureFin.getText());
        pln.setCoach(PlnCoachCombo.getValue());

        int selectedId = 0;
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT id FROM personne WHERE nom = ?");
            stmt.setString(1, pln.getCoach());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                selectedId = rs.getInt("id");
                // do something with selectedId
                System.out.println(selectedId);
            }

            if(pln.getHeureDebut().length()==0){
                lavel.setText("please enter name");
                return;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con=DBUtil.getConnection();
            String sql="insert into planning values(0,?,?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setDate(1, (Date) pln.getDate());
            pstmt.setString(2,pln.getHeureDebut());
            pstmt.setString(3,pln.getHeureFin());
            pstmt.setInt(4,selectedId);
            pstmt.executeUpdate();
            lavel.setText("Register Sucessfully.");
            showAllPlan();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllPlan(){
        try {
            PlnTableView.getItems().clear();
            con =DBUtil.getConnection();
            String sql="select * from planning";
            pstmt=con.prepareStatement(sql);

            rs=pstmt.executeQuery();
            while(rs.next()){
                PnlTableViewColID.setCellValueFactory(new PropertyValueFactory<Plan, Integer>("id"));
                PnlTableViewColDate.setCellValueFactory(new PropertyValueFactory<Plan, Date>("date"));
                PnlTableViewColHeureDebut.setCellValueFactory(new PropertyValueFactory<Plan, String>("heureDebut"));
                PnlTableViewColHeureFin.setCellValueFactory(new PropertyValueFactory<Plan, String>("heureFin"));
                PnlTableViewColCoach.setCellValueFactory(new PropertyValueFactory<Plan, String>("coach"));
                ObservableList<Plan> data = FXCollections.observableArrayList(
                        new Plan(rs.getInt("id"),rs.getDate("date"),rs.getString("heuredebut"),rs.getString("heurefin"),rs.getString("coach"))
                );
                PlnTableView.getItems().addAll(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePlan(){
        pln=new Plan();
        pln.setDate(Date.valueOf(PlnDateInput.getValue()));
        pln.setHeureDebut(PlnHeureDebut.getText());
        pln.setHeureFin(PlnHeureFin.getText());
        pln.setCoach(PlnCoachCombo.getValue());

        if(pln.getHeureDebut().length()<1){
            lavel.setText("please enter name");
            return;
        }

        try {
            con=DBUtil.getConnection();
            String sql="update planning set date=?,heuredebut=?,heurefin=?,coach=? where id in (select id from planning where coach=?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setDate(1, (Date) pln.getDate());
            pstmt.setString(2,pln.getHeureDebut());
            pstmt.setString(3,pln.getHeureFin());
            pstmt.setString(4, pln.getCoach());
            pstmt.setString(5, pln.getCoach());
            pstmt.executeUpdate();
            lavel.setText("Update Sucessfully.");
            showAllPlan();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void deletePlan(){
        pln=new Plan();
        pln.setHeureDebut(PlnHeureDebut.getText());
        pln.setHeureFin(PlnHeureFin.getText());
        pln.setCoach(PlnCoachCombo.getValue());

        try {
            con =DBUtil.getConnection();
            String sql="delete from planning where coach=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, pln.getCoach());
            pstmt.executeUpdate();
            lavel.setText("Record deleted ");
            showAllPlan();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}