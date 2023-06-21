package com.rhsv1.utilities;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Properties;

	public class ReadConfig {

		Properties prop;

		/*
		 * public static void main(String args[]) throws IOException { ReadConfig rc =
		 * new ReadConfig(); System.out.println(rc.getBrowserName()); }
		 */

		public ReadConfig() {
			FileReader fr;
			try {
				fr = new FileReader("./Configuration/Config.properties");
				prop = new Properties();
				prop.load(fr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public String getBrowserName() {
			String browser = prop.getProperty("browserName");
			return browser;
		}

		public String getApplicationUrl() {
			String url = prop.getProperty("urlString");
			return url;
		}

		public String getUserName() {
			String userName = prop.getProperty("usernameString");
			return userName;
		}

		public String getPassword() {
			String password = prop.getProperty("passwordString");
			return password;
		}

	}


