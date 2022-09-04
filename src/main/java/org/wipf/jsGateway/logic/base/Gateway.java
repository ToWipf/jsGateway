package org.wipf.jsGateway.logic.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class Gateway {

	public Response doPath(String sPath) throws IOException {

		String sUrl = "http://192.168.2.11:8080/" + sPath;

		URL url = new URL(sUrl.substring(0, Math.min(sUrl.length(), 4000)));

		System.out.println(url);

		HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
		urlc.setRequestMethod(HttpMethod.GET);
		urlc.setRequestProperty("Accept", "*/*");
		urlc.setConnectTimeout(5000); // 5 Sek.
		urlc.setReadTimeout(60000); // 1 Min.

		urlc.setDoOutput(true);

		urlc.setAllowUserInteraction(false);

		// get result
		BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
		String l = null;
		StringBuilder sbOut = new StringBuilder();
		while ((l = br.readLine()) != null) {
			sbOut.append(l);
		}
		br.close();

		return Response.ok(sbOut.toString()).build();
	}

}
