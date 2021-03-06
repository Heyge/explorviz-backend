package net.explorviz.model.application;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import net.explorviz.model.helper.BaseEntity;

/**
 * Model representing communication between two {@link Application}s
 *
 * @author Christian Zirkelbach (czi@informatik.uni-kiel.de)
 *
 */
@SuppressWarnings("serial")
@Type("applicationcommunication")
public class ApplicationCommunication extends BaseEntity {

	private int requests;
	private String technology;

	// in ns
	private float averageResponseTime;

	@Relationship("sourceApplication")
	private Application sourceApplication;

	@Relationship("targetApplication")
	private Application targetApplication;

	@Relationship("sourceClazz")
	private Clazz sourceClazz;

	@Relationship("targetClazz")
	private Clazz targetClazz;

	public int getRequests() {
		return requests;
	}

	public void setRequests(final int requests) {
		this.requests = requests;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(final String technology) {
		this.technology = technology;
	}

	public float getAverageResponseTime() {
		return averageResponseTime;
	}

	public void setAverageResponseTime(final float averageResponseTime) {
		this.averageResponseTime = averageResponseTime;
	}

	public Application getSourceApplication() {
		return sourceApplication;
	}

	public void setSourceApplication(final Application sourceApplication) {
		this.sourceApplication = sourceApplication;
	}

	public Application getTargetApplication() {
		return targetApplication;
	}

	public void setTargetApplication(final Application targetApplication) {
		this.targetApplication = targetApplication;
	}

	public Clazz getSourceClazz() {
		return sourceClazz;
	}

	public void setSourceClazz(final Clazz sourceClazz) {
		this.sourceClazz = sourceClazz;
	}

	public Clazz getTargetClazz() {
		return targetClazz;
	}

	public void setTargetClazz(final Clazz targetClazz) {
		this.targetClazz = targetClazz;
	}

	public void reset() {
		requests = 0;
		averageResponseTime = 0;
	}

}