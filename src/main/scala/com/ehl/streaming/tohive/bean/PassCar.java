package com.ehl.streaming.tohive.bean;

import com.google.gson.Gson;

public class PassCar {
	private String kkbh;
	private String gcsj;
	private String fxlx;
	private String hphm;
	private String hpzl;
	private String cdh;
	private String gcxh;
	private String hpys;
	private String cwkc;
	private String clsd;
	private String csys;
	private String clpp;
	private String cllx;
	private String fzhpzl;
	private String fzhphm;
	private String fzhpys;
	private String tplj;
	private String tp1;
	private String tp2;
	private String tp3;
	private String zwrksj;
	private String rdlsj;
	private String nwrksj;
	private String bz;
	private String xxly;
	private String hrksj;
	private String kklx;
	private String glbm;
	private String xzqh;
	private String dldm;
	private String dllx;
	private String ddbh;
	
	
	
	public static PassCar coverToBean(String json){
		Gson gson = new Gson();
		return gson.fromJson(json, PassCar.class);
	}
	
	public PassCar() {
		super();
	}
	public String getKkbh() {
		return kkbh;
	}
	public void setKkbh(String kkbh) {
		this.kkbh = kkbh;
	}
	public String getGcsj() {
		return gcsj;
	}
	public void setGcsj(String gcsj) {
		this.gcsj = gcsj;
	}
	public String getFxlx() {
		return fxlx;
	}
	public void setFxlx(String fxlx) {
		this.fxlx = fxlx;
	}
	public String getHphm() {
		return hphm;
	}
	public void setHphm(String hphm) {
		this.hphm = hphm;
	}
	public String getHpzl() {
		return hpzl;
	}
	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}
	public String getCdh() {
		return cdh;
	}
	public void setCdh(String cdh) {
		this.cdh = cdh;
	}
	public String getGcxh() {
		return gcxh;
	}
	public void setGcxh(String gcxh) {
		this.gcxh = gcxh;
	}
	public String getHpys() {
		return hpys;
	}
	public void setHpys(String hpys) {
		this.hpys = hpys;
	}
	public String getCwkc() {
		return cwkc;
	}
	public void setCwkc(String cwkc) {
		this.cwkc = cwkc;
	}
	public String getClsd() {
		return clsd;
	}
	public void setClsd(String clsd) {
		this.clsd = clsd;
	}
	public String getCsys() {
		return csys;
	}
	public void setCsys(String csys) {
		this.csys = csys;
	}
	public String getClpp() {
		return clpp;
	}
	public void setClpp(String clpp) {
		this.clpp = clpp;
	}
	public String getCllx() {
		return cllx;
	}
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	public String getFzhpzl() {
		return fzhpzl;
	}
	public void setFzhpzl(String fzhpzl) {
		this.fzhpzl = fzhpzl;
	}
	public String getFzhphm() {
		return fzhphm;
	}
	public void setFzhphm(String fzhphm) {
		this.fzhphm = fzhphm;
	}
	public String getFzhpys() {
		return fzhpys;
	}
	public void setFzhpys(String fzhpys) {
		this.fzhpys = fzhpys;
	}
	public String getTplj() {
		return tplj;
	}
	public void setTplj(String tplj) {
		this.tplj = tplj;
	}
	public String getTp1() {
		return tp1;
	}
	public void setTp1(String tp1) {
		this.tp1 = tp1;
	}
	public String getTp2() {
		return tp2;
	}
	public void setTp2(String tp2) {
		this.tp2 = tp2;
	}
	public String getTp3() {
		return tp3;
	}
	public void setTp3(String tp3) {
		this.tp3 = tp3;
	}
	public String getZwrksj() {
		return zwrksj;
	}
	public void setZwrksj(String zwrksj) {
		this.zwrksj = zwrksj;
	}
	public String getRdlsj() {
		return rdlsj;
	}
	public void setRdlsj(String rdlsj) {
		this.rdlsj = rdlsj;
	}
	public String getNwrksj() {
		return nwrksj;
	}
	public void setNwrksj(String nwrksj) {
		this.nwrksj = nwrksj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXxly() {
		return xxly;
	}
	public void setXxly(String xxly) {
		this.xxly = xxly;
	}
	public String getHrksj() {
		return hrksj;
	}
	public void setHrksj(String hrksj) {
		this.hrksj = hrksj;
	}
	public String getKklx() {
		return kklx;
	}
	public void setKklx(String kklx) {
		this.kklx = kklx;
	}
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	public String getDldm() {
		return dldm;
	}
	public void setDldm(String dldm) {
		this.dldm = dldm;
	}
	public String getDllx() {
		return dllx;
	}
	public void setDllx(String dllx) {
		this.dllx = dllx;
	}
	public String getDdbh() {
		return ddbh;
	}
	public void setDdbh(String ddbh) {
		this.ddbh = ddbh;
	}
	@Override
	public String toString() {
		return "PassCar [kkbh=" + kkbh + ", gcsj=" + gcsj + ", fxlx=" + fxlx + ", hphm=" + hphm
				+ ", hpzl=" + hpzl + ", cdh=" + cdh + ", gcxh=" + gcxh + ", hpys=" + hpys + ", cwkc=" + cwkc + ", clsd="
				+ clsd + ", csys=" + csys + ", clpp=" + clpp + ", cllx=" + cllx + ", fzhpzl=" + fzhpzl + ", fzhphm="
				+ fzhphm + ", fzhpys=" + fzhpys + ", tplj=" + tplj + ", tp1=" + tp1 + ", tp2=" + tp2 + ", tp3=" + tp3
				+ ", zwrksj=" + zwrksj + ", rdlsj=" + rdlsj + ", nwrksj=" + nwrksj + ", bz=" + bz + ", xxly=" + xxly
				+ ", hrksj=" + hrksj + ", kklx=" + kklx + ", glbm=" + glbm + ", xzqh=" + xzqh + ", dldm=" + dldm
				+ ", dllx=" + dllx + ", ddbh=" + ddbh + "]";
	}
	
}
