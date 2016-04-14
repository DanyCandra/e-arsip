/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.model;

import com.dany.plo.dao.UserDao;
import com.dany.plo.dao.impl.UserDaoImpl;
import com.dany.plo.entitas.User;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dany Candra
 */
public class UserModel {

    private String idUser;
    @TableColumn(name = "USERNAME", number = 1, size = 40)
    private String userName;
    @TableColumn(name = "PASSWORD", number = 2, size = 40)
    private String password;
    @TableColumn(name = "NAMA", number = 2, size = 40)
    private String nama;

    public UserModel() {
    }

    public UserModel(String idUser, String userName, String password, String nama) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.nama = nama;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<UserModel> load(int skip, int max) throws ArsipException {
        List<UserModel> list = new ArrayList<>();

        UserDao dao = DatabaseUtilities.getUserDao();
        List<User> listTmp = dao.getUser(skip, max);
        for (User user : listTmp) {
            UserModel model = new UserModel();
            model.setIdUser(user.getIdUser());
            model.setNama(user.getNama());
            model.setPassword(user.getPassword());
            model.setUserName(user.getUserName());
            list.add(model);
        }
        return list;
    }

    public Long getLongList() throws ArsipException {
        Long longList = 0L;
        UserDao dao = DatabaseUtilities.getUserDao();
        longList = dao.count();
        return longList;
    }

    public void insert() throws ArsipException {
        User user = new User();
        user.setIdUser(idUser);
        user.setNama(nama);
        user.setPassword(password);
        user.setUserName(userName);

        UserDao dao = DatabaseUtilities.getUserDao();
        dao.insertUser(user);
    }

    public void update() throws ArsipException {
        User user = new User();
        user.setIdUser(idUser);
        user.setNama(nama);
        user.setPassword(password);
        user.setUserName(userName);

        UserDao dao = DatabaseUtilities.getUserDao();
        dao.updateUser(user);
    }

    public boolean isDelete() throws ArsipException {
        UserDao dao = DatabaseUtilities.getUserDao();
        boolean result = dao.canDelete(idUser);
        return result;
    }

    public void delete() throws ArsipException {
        UserDao dao = DatabaseUtilities.getUserDao();
        dao.delete(idUser);
    }

    public User getUserFromModel(UserModel model) {
        User user = new User();
        user.setIdUser(model.getIdUser());
        user.setNama(model.getNama());
        user.setPassword(model.getPassword());
        user.setUserName(model.getUserName());
        return user;
    }

    public UserModel getDummyUser() {
        UserModel model = new UserModel();
        UserDao dao = DatabaseUtilities.getUserDao();
        User user = new User();
        try {
            user = dao.getUser("NK.0476", "KELALEN");
            model.setIdUser(user.getIdUser());
            model.setNama(user.getNama());
            model.setPassword(user.getPassword());
            model.setUserName(user.getUserName());
        } catch (ArsipException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }

    public UserModel getByIdUser(String idUser) throws ArsipException {
        UserDao dao = DatabaseUtilities.getUserDao();
        User user = dao.getUser(idUser);
        UserModel model =new UserModel();
        if (user != null) {
            model.setIdUser(user.getIdUser());
            model.setNama(user.getNama());
            model.setPassword(user.getPassword());
            model.setUserName(user.getUserName());
        }

        return model;
    }

}
