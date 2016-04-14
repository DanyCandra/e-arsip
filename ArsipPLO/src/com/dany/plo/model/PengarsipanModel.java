/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.model;

import com.dany.plo.dao.PengarsipanDao;
import com.dany.plo.dao.impl.PengarsipanDaoImpl;
import com.dany.plo.entitas.Pengarsipan;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import com.dany.plo.view.resource.render.table.DebiturRender;
import com.dany.plo.view.resource.render.table.DusRender;
import com.dany.plo.view.resource.render.table.PejabatRender;
import com.dany.plo.view.resource.render.table.StatusBerkasRender;
import com.dany.plo.view.resource.render.table.UserRender;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dany Candra
 */
public class PengarsipanModel {

    private String idArsip;
    @TableColumn(name = "CIF", number = 1, size = 10, renderer = DebiturRender.class, groups = {"ttpengembalian"})
    private DebiturModel debiturModel;
    @TableColumn(name = "NAMA", number = 2, size = 40, groups = {"ttpengembalian"})
    private String nama;
    @TableColumn(name = "TANGGAL TERIMA", number = 3, size = 20, groups = {"ttpengembalian"})
    private Date tanggalTerima;
    @TableColumn(name = "PETUGAS PENERIMA", number = 4, size = 30, renderer = UserRender.class, groups = {"ttpengembalian"})
    private UserModel userPenerima;
    @TableColumn(name = "PEJABAT PENERIMA", number = 5, size = 30, renderer = PejabatRender.class, groups = {"ttpengembalian"})
    private PejabatModel pejabatPenerima;
    @TableColumn(name = "DUS", number = 6, size = 5, renderer = DusRender.class, groups = {"ttpengembalian"})
    private DusModel dus;
    @TableColumn(name = "TANGGAL KEMBALI", number = 7, size = 20)
    private Date tanggalKembali;
    @TableColumn(name = "PETUGAS PENGEMBALI", number = 8, size = 30)
    private UserModel userPengembali;
    @TableColumn(name = "PEJABAT PENGEMBALI", number = 9, size = 30)
    private PejabatModel pejabatPengembali;
    @TableColumn(name = "STATUS BERKAS", number = 10, size = 20, renderer = StatusBerkasRender.class, groups = {"ttpengembalian"})
    private String statusArsip;
    @TableColumn(name = "STATUS KEMBALI", number = 11, size = 5)
    private String statusKembali;

    public PengarsipanModel() {
    }

    public PengarsipanModel(String idArsip, DebiturModel debiturModel, Date tanggalTerima, UserModel userPenerima, PejabatModel pejabatPenerima, DusModel dus, Date tanggalKembali, UserModel userPengembali, PejabatModel pejabatPengembali, String statusArsip, String statusKembali) {
        this.idArsip = idArsip;
        this.debiturModel = debiturModel;
        this.tanggalTerima = tanggalTerima;
        this.userPenerima = userPenerima;
        this.pejabatPenerima = pejabatPenerima;
        this.dus = dus;
        this.tanggalKembali = tanggalKembali;
        this.userPengembali = userPengembali;
        this.pejabatPengembali = pejabatPengembali;
        this.statusArsip = statusArsip;
        this.statusKembali = statusKembali;
    }

    public String getIdArsip() {
        return idArsip;
    }

    public void setIdArsip(String idArsip) {
        this.idArsip = idArsip;
    }

    public DebiturModel getDebiturModel() {
        return debiturModel;
    }

    public void setDebiturModel(DebiturModel debiturModel) {
        this.debiturModel = debiturModel;
    }

    public Date getTanggalTerima() {
        return tanggalTerima;
    }

    public void setTanggalTerima(Date tanggalTerima) {
        this.tanggalTerima = tanggalTerima;
    }

    public UserModel getUserPenerima() {
        return userPenerima;
    }

    public void setUserPenerima(UserModel userPenerima) {
        this.userPenerima = userPenerima;
    }

    public PejabatModel getPejabatPenerima() {
        return pejabatPenerima;
    }

    public void setPejabatPenerima(PejabatModel pejabatPenerima) {
        this.pejabatPenerima = pejabatPenerima;
    }

    public DusModel getDus() {
        return dus;
    }

    public void setDus(DusModel dus) {
        this.dus = dus;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public UserModel getUserPengembali() {
        return userPengembali;
    }

    public void setUserPengembali(UserModel userPengembali) {
        this.userPengembali = userPengembali;
    }

    public PejabatModel getPejabatPengembali() {
        return pejabatPengembali;
    }

    public void setPejabatPengembali(PejabatModel pejabatPengembali) {
        this.pejabatPengembali = pejabatPengembali;
    }

    public String getStatusArsip() {
        return statusArsip;
    }

    public void setStatusArsip(String statusArsip) {
        this.statusArsip = statusArsip;
    }

    public String getStatusKembali() {
        return statusKembali;
    }

    public void setStatusKembali(String statusKembali) {
        this.statusKembali = statusKembali;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void saveAsPenerimaan() throws ArsipException {
        PengarsipanDao dao = DatabaseUtilities.getPengarsipanDao();
        Pengarsipan pengarsipan = new Pengarsipan();
        pengarsipan.setIdArsip(idArsip);
        pengarsipan.setDebitur(new DebiturModel().getDebiturFromModel(debiturModel));
        pengarsipan.setDus(new DusModel().getDusFromModel(dus));
        pengarsipan.setTanggalTerima(tanggalTerima);
        pengarsipan.setUserPenerima(new UserModel().getUserFromModel(userPenerima));
        pengarsipan.setPejabatPenerima(new PejabatModel().getPejabatFromModel(pejabatPenerima));
        pengarsipan.setStatusArsip(statusArsip);

        dao.insertPenerimaan(pengarsipan);
    }
    
    

    public void updatePenerimaan() throws ArsipException {
        PengarsipanDao dao = DatabaseUtilities.getPengarsipanDao();
        Pengarsipan pengarsipan = new Pengarsipan();
        pengarsipan.setIdArsip(idArsip);
        pengarsipan.setDebitur(new DebiturModel().getDebiturFromModel(debiturModel));
        pengarsipan.setDus(new DusModel().getDusFromModel(dus));
        pengarsipan.setTanggalTerima(tanggalTerima);
        pengarsipan.setUserPenerima(new UserModel().getUserFromModel(userPenerima));
        pengarsipan.setPejabatPenerima(new PejabatModel().getPejabatFromModel(pejabatPenerima));
        pengarsipan.setStatusArsip(statusArsip);

        dao.updatePenerimaan(pengarsipan);
    }
    
     public void saveAsPengembalian() throws ArsipException {
        PengarsipanDao dao = DatabaseUtilities.getPengarsipanDao();
        Pengarsipan pengarsipan = new Pengarsipan();
        pengarsipan.setIdArsip(idArsip);
        pengarsipan.setTanggalKembali(tanggalKembali);
        pengarsipan.setUserPengembali(new UserModel().getUserFromModel(userPengembali));
        pengarsipan.setPejabatPengembali(new PejabatModel().getPejabatFromModel(pejabatPengembali));
        pengarsipan.setStatusArsip(statusArsip);
        pengarsipan.setStatusKembali(statusKembali);

        dao.insertPengembalian(pengarsipan);
    }

    public boolean cekPenerimaanByCIF(String cif) throws ArsipException {
        PengarsipanDao dao = DatabaseUtilities.getPengarsipanDao();
        Pengarsipan pengarsipan = dao.getPengarsipanByCIF(cif);
        boolean result = false;

        if (pengarsipan != null) {
            if (pengarsipan.getStatusArsip().equals("1")) {
                result = true;
            }

        } else {
            result = false;
        }

        return result;
    }

    public void getParameterPenerimaanBy(String cif) throws ArsipException {
        PengarsipanDao dao = DatabaseUtilities.getPengarsipanDao();
        Pengarsipan pengarsipan = dao.getPengarsipanByCIF(cif);

        setIdArsip(pengarsipan.getIdArsip());
        setDebiturModel(new DebiturModel().getDebiturModelByCif(pengarsipan.getDebitur().getCif()));
        setTanggalTerima(pengarsipan.getTanggalTerima());
        setUserPenerima(new UserModel().getByIdUser(pengarsipan.getUserPenerima().getIdUser()));
        setPejabatPenerima(new PejabatModel().getById(pengarsipan.getIdArsip()));
        setDus(new DusModel().getById(pengarsipan.getDus().getIdDus()));
        setStatusArsip(pengarsipan.getStatusArsip());

    }

    public List<PengarsipanModel> getDaftarBerkasTersedia(int skip, int max) throws ArsipException {
        List<PengarsipanModel> list = new ArrayList<>();

        PengarsipanDao dao = DatabaseUtilities.getPengarsipanDao();
        List<Pengarsipan> tmpList = dao.getDaftarBerkasTersedia(skip, max);
        for (Pengarsipan pengarsipan : tmpList) {
            PengarsipanModel model = new PengarsipanModel();
            model.setIdArsip(pengarsipan.getIdArsip());
            model.setDebiturModel(new DebiturModel().getDebiturModelByCif(pengarsipan.getDebitur().getCif()));
            model.setNama(new DebiturModel().getDebiturModelByCif(pengarsipan.getDebitur().getCif()).getNama());
            model.setTanggalTerima(pengarsipan.getTanggalTerima());
            model.setUserPenerima(new UserModel().getByIdUser(pengarsipan.getUserPenerima().getIdUser()));
            model.setPejabatPenerima(new PejabatModel().getById(pengarsipan.getPejabatPenerima().getIdPejabat()));
            model.setDus(new DusModel().getById(pengarsipan.getDus().getIdDus()));
            model.setStatusArsip(pengarsipan.getStatusArsip());
            list.add(model);
        }
        return list;
    }

    public List<PengarsipanModel> searchDaftarBerkasTersedia(String cif) throws ArsipException {
        List<PengarsipanModel> list = new ArrayList<>();

        PengarsipanDao dao = DatabaseUtilities.getPengarsipanDao();
        List<Pengarsipan> tmpList = dao.getDaftarBerkasTersedia(cif);
        for (Pengarsipan pengarsipan : tmpList) {
            PengarsipanModel model = new PengarsipanModel();
            model.setIdArsip(pengarsipan.getIdArsip());
            model.setDebiturModel(new DebiturModel().getDebiturModelByCif(pengarsipan.getDebitur().getCif()));
            model.setNama(new DebiturModel().getDebiturModelByCif(pengarsipan.getDebitur().getCif()).getNama());
            model.setTanggalTerima(pengarsipan.getTanggalTerima());
            model.setUserPenerima(new UserModel().getByIdUser(pengarsipan.getUserPenerima().getIdUser()));
            model.setPejabatPenerima(new PejabatModel().getById(pengarsipan.getPejabatPenerima().getIdPejabat()));
            model.setDus(new DusModel().getById(pengarsipan.getDus().getIdDus()));
            model.setStatusArsip(pengarsipan.getStatusArsip());
            list.add(model);
        }
        return list;
    }

    public int getCountBerkasTersedia() throws ArsipException {
        int result = 0;
        PengarsipanDao dao = DatabaseUtilities.getPengarsipanDao();
        Long total = dao.getLongPenerimaan();

        result = total.intValue();

        return result;
    }
}
