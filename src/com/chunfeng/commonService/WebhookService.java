package com.chunfeng.commonService;

import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Stateless
@Path("webhook")
public class WebhookService {

	
	@POST
	@Path("virifyWebhook")
	@Produces("application/json")
	public Object virifyWebhook(@FormParam("json") String json){
		System.out.println("json = " + json);
		return null;
	}
	
}
