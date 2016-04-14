/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dany.plo.model;

import com.dany.plo.dao.DebiturDao;
import com.dany.plo.dao.impl.DebiturDaoImpl;
import com.dany.plo.dao.impl.InstansiDaoImpl;
import com.dany.plo.entitas.Debitur;
import com.dany.plo.entitas.Instansi;
import com.dany.plo.exception.ArsipException;
import com.dany.plo.utilities.DatabaseUtilities;
import java.util.Date;

/**
 *
 * @author Dany Candra
 */
public class DebiturModel {

    private String cif;
    private String nama;
    private String tempatLahir;
    private Date tanggalLahir;
    private String nik;
    private String alamat;
    private String kelurahan;
    private String kecamatan;
    private String telepon;
    private String skCpns;
    private String skPengangkatan;
    private String skTerakhir;
    private String taspen;
    private String skPensiun;
    private String karip;
    private String shm;
    private String sht;
    private String ijazah;
    private String lainnya;
    private InstansiModel instansi;

    public DebiturModel() {
    }

    public DebiturModel(String cif, String nama, String tempatLahir, Date tanggalLahir, String nik, String alamat, String kelurahan, String kecamatan, String telepon, String skCpns, String skPengangkatan, String skTerakhir, String taspen, String skPensiun, String karip, String shm, String sht, String ijazah, String lainnya, InstansiModel instansi) {
        this.cif = cif;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.nik = nik;
        this.alamat = alamat;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.telepon = telepon;
        this.skCpns = skCpns;
        this.skPengangkatan = skPengangkatan;
        this.skTerakhir = skTerakhir;
        this.taspen = taspen;
        this.skPensiun = skPensiun;
        this.karip = karip;
        this.shm = shm;
        this.sht = sht;
        this.ijazah = ijazah;
        this.lainnya = lainnya;
        this.instansi = instansi;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getSkCpns() {
        return skCpns;
    }

    public void setSkCpns(String skCpns) {
        this.skCpns = skCpns;
    }

    public String getSkPengangkatan() {
        return skPengangkatan;
    }

    public void setSkPengangkatan(String skPengangkatan) {
        this.skPengangkatan = skPengangkatan;
    }

    public String getSkTerakhir() {
        return skTerakhir;
    }

    public void setSkTerakhir(String skTerakhir) {
        this.skTerakhir = skTerakhir;
    }

    public String getTaspen() {
        return taspen;
    }

    public void setTaspen(String taspen) {
        this.taspen = taspen;
    }

    public String getSkPensiun() {
        return skPensiun;
    }

    public void setSkPensiun(String skPensiun) {
        this.skPensiun = skPensiun;
    }

    public String getKarip() {
        return karip;
    }

    public void setKarip(String karip) {
        this.karip = karip;
    }

    public String getShm() {
        return shm;
    }

    public void setShm(String shm) {
        this.shm = shm;
    }

    public String getSht() {
        return sht;
    }

    public void setSht(String sht) {
        this.sht = sht;
    }

    public String getIjazah() {
        return ijazah;
    }

    public void setIjazah(String ijazah) {
        this.ijazah = ijazah;
    }

    public String getLainnya() {
        return lainnya;
    }

    public void setLainnya(String lainnya) {
        this.lainnya = lainnya;
    }

    public InstansiModel getInstansi() {
        return instansi;
    }

    public void setInstansi(InstansiModel instansi) {
        this.instansi = instansi;
    }

    @Override
    public String toString() {
        return "DebiturModel{" + "cif=" + cif + ", nama=" + nama + ", tempatLahir=" + tempatLahir + ", tanggalLahir=" + tanggalLahir + ", nik=" + nik + ", alamat=" + alamat + ", kelurahan=" + kelurahan + ", kecamatan=" + kecamatan + ", telepon=" + telepon + ", skCpns=" + skCpns + ", skPengangkatan=" + skPengangkatan + ", skTerakhir=" + skTerakhir + ", taspen=" + taspen + ", skPensiun=" + skPensiun + ", karip=" + karip + ", shm=" + shm + ", sht=" + sht + ", ijazah=" + ijazah + ", lainnya=" + lainnya + ", instansi=" + instansi + '}';
    }

    public void insertDebitur() throws ArsipException {

        Debitur debitur = new Debitur();
        debitur.setCif(cif);
        debitur.setNama(nama);
        debitur.setTempatLahir(tempatLahir);
        debitur.setTanggalLahir(tanggalLahir);
        debitur.setNik(nik);
        debitur.setAlamat(alamat);
        debitur.setKelurahan(kelurahan);
        debitur.setKecamatan(kecamatan);
        debitur.setTelepon(telepon);
        debitur.setSkCpns(skCpns);
        debitur.setSkPengangkatan(skPengangkatan);
        debitur.setSkTerakhir(skTerakhir);
        debitur.setTaspen(taspen);
        debitur.setSkPensiun(skPensiun);
        debitur.setKarip(karip);
        debitur.setShm(shm);
        debitur.setSht(sht);
        debitur.setIjazah(ijazah);
        debitur.setLainnya(lainnya);

        debitur.setInstansi(new InstansiModel().getInstansiFromModel(instansi));

        DebiturDao dao = DatabaseUtilities.getDebiturDao();
        dao.insertDebitur(debitur);
    }

    public void updateDebitur() throws ArsipException {

        Debitur debitur = new Debitur();
        debitur.setCif(cif);
        debitur.setNama(nama);
        debitur.setTempatLahir(tempatLahir);
        debitur.setTanggalLahir(tanggalLahir);
        debitur.setNik(nik);
        debitur.setAlamat(alamat);
        debitur.setKelurahan(kelurahan);
        debitur.setKecamatan(kecamatan);
        debitur.setTelepon(telepon);
        debitur.setSkCpns(skCpns);
        debitur.setSkPengangkatan(skPengangkatan);
        debitur.setSkTerakhir(skTerakhir);
        debitur.setTaspen(taspen);
        debitur.setSkPensiun(skPensiun);
        debitur.setKarip(karip);
        debitur.setShm(shm);
        debitur.setSht(sht);
        debitur.setIjazah(ijazah);
        debitur.setLainnya(lainnya);

        debitur.setInstansi(new InstansiModel().getInstansiFromModel(instansi));

        DebiturDao dao = DatabaseUtilities.getDebiturDao();
        dao.updateDebitur(debitur);
    }

    public Debitur getDebiturFromModel(DebiturModel model) {
        Debitur debitur = new Debitur();
        debitur.setCif(model.getCif());
        debitur.setNama(model.getNama());
        debitur.setTempatLahir(model.getTempatLahir());
        debitur.setTanggalLahir(model.getTanggalLahir());
        debitur.setNik(model.getNik());
        debitur.setAlamat(model.getAlamat());
        debitur.setKelurahan(model.getKelurahan());
        debitur.setKecamatan(model.getKecamatan());
        debitur.setTelepon(model.getTelepon());
        debitur.setSkCpns(model.getSkCpns());
        debitur.setSkPengangkatan(model.getSkPengangkatan());
        debitur.setSkTerakhir(model.getSkTerakhir());
        debitur.setTaspen(model.getTaspen());
        debitur.setSkPensiun(model.getSkPensiun());
        debitur.setKarip(model.getKarip());
        debitur.setShm(model.getShm());
        debitur.setSht(model.getSht());
        debitur.setIjazah(model.getIjazah());
        debitur.setInstansi(model.getInstansi().getInstansiFromModel(model.getInstansi()));
        return debitur;
    }

    public void getByCif(String cif) throws ArsipException {
        DebiturDao dao = DatabaseUtilities.getDebiturDao();
        Debitur model = dao.getDebitur(cif);

        if (model != null) {
            setCif(model.getCif());
            setNama(model.getNama());
            setTempatLahir(model.getTempatLahir());
            setTanggalLahir(model.getTanggalLahir());
            setNik(model.getNik());
            setAlamat(model.getAlamat());
            setKelurahan(model.getKelurahan());
            setKecamatan(model.getKecamatan());
            setTelepon(model.getTelepon());
            setSkCpns(model.getSkCpns());
            setSkPengangkatan(model.getSkPengangkatan());
            setSkTerakhir(model.getSkTerakhir());
            setTaspen(model.getTaspen());
            setSkPensiun(model.getSkPensiun());
            setKarip(model.getKarip());
            setShm(model.getShm());
            setSht(model.getSht());
            setIjazah(model.getIjazah());
            setInstansi(new InstansiModel().getInstansiModel(model.getInstansi().getIdInstans()));
        }

    }

    public DebiturModel getDebiturModelByCif(String cif) throws ArsipException {
        DebiturDao dao = DatabaseUtilities.getDebiturDao();
        Debitur model = dao.getDebitur(cif);
        DebiturModel debiturModel = new DebiturModel();
        if (model != null) {
            debiturModel.setCif(model.getCif());
            debiturModel.setNama(model.getNama());
            debiturModel.setTempatLahir(model.getTempatLahir());
            debiturModel.setTanggalLahir(model.getTanggalLahir());
            debiturModel.setNik(model.getNik());
            debiturModel.setAlamat(model.getAlamat());
            debiturModel.setKelurahan(model.getKelurahan());
            debiturModel.setKecamatan(model.getKecamatan());
            debiturModel.setTelepon(model.getTelepon());
            debiturModel.setSkCpns(model.getSkCpns());
            debiturModel.setSkPengangkatan(model.getSkPengangkatan());
            debiturModel.setSkTerakhir(model.getSkTerakhir());
            debiturModel.setTaspen(model.getTaspen());
            debiturModel.setSkPensiun(model.getSkPensiun());
            debiturModel.setKarip(model.getKarip());
            debiturModel.setShm(model.getShm());
            debiturModel.setSht(model.getSht());
            debiturModel.setIjazah(model.getIjazah());
            debiturModel.setInstansi(new InstansiModel().getInstansiModel(model.getInstansi().getIdInstans()));
        }
        return debiturModel;
    }
}
