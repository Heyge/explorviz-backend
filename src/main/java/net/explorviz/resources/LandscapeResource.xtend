package net.explorviz.resources

import javax.inject.Inject
import javax.ws.rs.core.MediaType
import javax.ws.rs.Produces
import javax.ws.rs.GET
import javax.ws.rs.Path
import net.explorviz.server.repository.LandscapeRepositoryModel
import net.explorviz.layout.LayoutService
import javax.ws.rs.PathParam
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode

@Path("landscapes")
class LandscapeResource {

	var LandscapeRepositoryModel service

	@Inject
	def LandscapeResource(LandscapeRepositoryModel service) {
		this.service = service
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{landscapeId}")
	def ObjectNode getLandscape(@PathParam("landscapeId") String landscapeId) {
		
		var JsonNodeFactory factory = JsonNodeFactory.instance
		
		var data = factory.objectNode		
				
		var l = LayoutService::layoutLandscape(this.service.getLastPeriodLandscape())	
		
		data.putPOJO("data", l)
		
		data		
	}
}
