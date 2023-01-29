package com.SpringSecurity;

import java.io.FileInputStream;
import java.io.InputStream;

import com.openkm.sdk4j.OKMWebservices;
import com.openkm.sdk4j.OKMWebservicesFactory;
import com.openkm.sdk4j.bean.Folder;

public class OpenKMDemo {

	public static void main(String[] args) {
		
		String host="http://10.1.2.94:8080/OpenKM";
		String username="okmAdmin";
		String password="admin";
		OKMWebservices ws = OKMWebservicesFactory.newInstance(host, username, password);
		try {
			for(Folder fld:ws.getFolderChildren("/okm:root")) {
				System.out.println("fld: "+fld.getPath()+" - "+fld.getAuthor());
			}
			ws.createFolderSimple("/okm:root/test1");
			InputStream is = new FileInputStream("C:\\Users\\vivekr\\Desktop\\MCA-Sem4\\download.pdf");
			ws.createDocumentSimple("/okm:root/test1/download.pdf", is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
