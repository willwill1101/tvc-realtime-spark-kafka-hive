package com.ehl.streaming.tohive.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CarPlaBean {
	private String uid;
	private String version;
	private long passtime;// 通行时间
	private String carstate;// 车辆状态
	private String carplate;// 车牌号
	private String platetype;// 号牌种类
	private int speed;// 号牌种类
	private String platecolor;// 车牌颜色
	private String locationid;// 地点编号
	private String deviceid;
	private int driveway;// 车道编码
	private String drivedir;// 行驶方向
	private String capturedir;// 抓拍方向
	private String carcolor;// 车身颜色
	private String carbrand;// 车辆品牌
	private String carbrandzw;//中文车辆品牌
	private String tgsid;// 卡口编号
	private String platecoord;// 车牌坐标
	private String cabcoord;// 驾驶室坐标 	
	private String imgid1;// 图片文件名1
	private String imgid2;// 图片文件名2
	private String imgid3;// 图片文件名3
	private String imgid4;// 图片文件名3
	private String imgid5;// 图片文件名
	private String dt;
	private int passtime_yyyymm;
	
	public static CarPlaBean coverToCarPlaBean(PassCar p) throws ParseException{
		CarPlaBean cp =  new CarPlaBean();
		SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat  df2 = new SimpleDateFormat("yyyyMM");

		cp.setUid(UUIDGenerator.getUUID());
		cp.setVersion("1");
		cp.setPasstime(df.parse(p.getGcsj()).getTime());
		cp.setCarstate("1");
		cp.setCarplate(p.getHphm());
		cp.setPlatetype(p.getHpzl());
		cp.setSpeed(Integer.valueOf(p.getClsd()));
		cp.setPlatecolor(p.getHpys());
		cp.setLocationid("");
		cp.setDeviceid("");
		cp.setDriveway(Integer.valueOf(p.getCdh()));
		cp.setDrivedir(p.getFxlx());
		cp.setCapturedir("");
		cp.setCarcolor(p.getCsys());
		cp.setCarbrand("");
		cp.setCarbrandzw("");
		cp.setTgsid(p.getKkbh());
		cp.setPlatecoord("0,0,0,0");
		cp.setCabcoord("0,0,0,0");
		cp.setImgid1(p.getTplj()+p.getTp1());
		cp.setImgid2("");
		cp.setImgid3("");
		cp.setImgid4("");
		cp.setImgid5("");
		cp.setDt("");
		cp.setPasstime_yyyymm(Integer.valueOf(df2.format(df.parse(p.getGcsj()))));
//      rdd.foreachPartition(f => {
//      val conn = null
//       val stat = conn.prepareStatement("inert into  orc_passcar ( uid,version,passtime,carstate,carplate,platetype,speed,platecolor,locationid,deviceid,driveway,drivedir,capturedir,carcolor,carbrand,carbrandzw,tgsid,platecoord,cabcoord,imgid1,imgid2,imgid3,imgid4,imgid5,dt,passtime_yyyymm)" +
//          "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")
//      f.foreach(f2 => {
//        val gson = new Gson();
//        val df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//        val passCar: PassCar = gson.fromJson(f2._2, PassCar.getClass)
//        var index: Integer = 1;
//        stat.setString(index, UUIDGenerator.getUUID)
//        index += 1
//        stat.setString(index, "1")
//        index += 1
//        stat.setLong(index, df.parse(passCar.getGcsj).getTime())
//        index += 1
//        stat.setString(index, passCar.getHphm)
//        index += 1
//        stat.setInt(index, (Integer.valueOf(passCar.getClsd)))
//        index += 1
//        stat.setString(index, passCar.getHpys)
//        index += 1
//        stat.setString(index, "")
//        index += 1
//        stat.setString(index, "")
//        index += 1
//        stat.setInt(index, Integer.valueOf(passCar.getCdh))
//        index += 1
//        stat.setString(index, passCar.getFxlx)
//        index += 1
//        stat.setString(index, "1")
//        index += 1
//        stat.setString(index, passCar.getCsys)
//        index += 1
//        stat.setString(index, "")
//        index += 1
//        stat.setString(index, "")
//        index += 1
//        stat.setString(index, passCar.getKkbh)
//        index += 1
//        stat.setString(index, "0,0,0,0")
//        index += 1
//        stat.setString(index, "0,0,0,0")
//        index += 1
//        stat.setString(index, passCar.getTplj+passCar.getTp1)
//        index += 1
//        stat.setString(index, "")
//        index += 1
//        stat.setString(index, "")
//        index += 1
//        stat.setString(index, "")
//        index += 1
//        stat.setString(index, "")
//        stat.execute()
//      }
//      
//      )
//      conn.commit()
//      DataSource.realeaseResource(null, stat, conn)
//    })
		return cp;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public long getPasstime() {
		return passtime;
	}
	public void setPasstime(long passtime) {
		this.passtime = passtime;
	}
	public String getCarstate() {
		return carstate;
	}
	public void setCarstate(String carstate) {
		this.carstate = carstate;
	}
	public String getCarplate() {
		return carplate;
	}
	public void setCarplate(String carplate) {
		this.carplate = carplate;
	}
	public String getPlatetype() {
		return platetype;
	}
	public void setPlatetype(String platetype) {
		this.platetype = platetype;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getPlatecolor() {
		return platecolor;
	}
	public void setPlatecolor(String platecolor) {
		this.platecolor = platecolor;
	}
	public String getLocationid() {
		return locationid;
	}
	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}
	public int getDriveway() {
		return driveway;
	}
	public void setDriveway(int driveway) {
		this.driveway = driveway;
	}
	public String getDrivedir() {
		return drivedir;
	}
	public void setDrivedir(String drivedir) {
		this.drivedir = drivedir;
	}
	public String getCapturedir() {
		return capturedir;
	}
	public void setCapturedir(String capturedir) {
		this.capturedir = capturedir;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public String getCarbrand() {
		return carbrand;
	}
	public void setCarbrand(String carbrand) {
		this.carbrand = carbrand;
	}
	public String getCarbrandzw() {
		return carbrandzw;
	}
	public void setCarbrandzw(String carbrandzw) {
		this.carbrandzw = carbrandzw;
	}
	public String getTgsid() {
		return tgsid;
	}
	public void setTgsid(String tgsid) {
		this.tgsid = tgsid;
	}
	public String getPlatecoord() {
		return platecoord;
	}
	public void setPlatecoord(String platecoord) {
		this.platecoord = platecoord;
	}
	public String getCabcoord() {
		return cabcoord;
	}
	public void setCabcoord(String cabcoord) {
		this.cabcoord = cabcoord;
	}
	public String getImgid1() {
		return imgid1;
	}
	public void setImgid1(String imgid1) {
		this.imgid1 = imgid1;
	}
	public String getImgid2() {
		return imgid2;
	}
	public void setImgid2(String imgid2) {
		this.imgid2 = imgid2;
	}
	public String getImgid3() {
		return imgid3;
	}
	public void setImgid3(String imgid3) {
		this.imgid3 = imgid3;
	}
	public String getImgid4() {
		return imgid4;
	}
	public void setImgid4(String imgid4) {
		this.imgid4 = imgid4;
	}
	public String getImgid5() {
		return imgid5;
	}
	public void setImgid5(String imgid5) {
		this.imgid5 = imgid5;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public int getPasstime_yyyymm() {
		return passtime_yyyymm;
	}
	public void setPasstime_yyyymm(int passtime_yyyymm) {
		this.passtime_yyyymm = passtime_yyyymm;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	
	
	
}
