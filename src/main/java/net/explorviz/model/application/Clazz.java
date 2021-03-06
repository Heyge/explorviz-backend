package net.explorviz.model.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import net.explorviz.model.helper.BaseEntity;

/**
 * Model representing a single class (instance during runtime within a single
 * application)
 *
 * @author Christian Zirkelbach (czi@informatik.uni-kiel.de)
 *
 */
@SuppressWarnings("serial")
@Type("clazz")
public class Clazz extends BaseEntity {

	private String name;
	private String fullQualifiedName;
	private int instanceCount;
	private transient Set<Integer> objectIds = new HashSet<Integer>();

	@Relationship("parent")
	private Component parent;

	@Relationship("outgoingClazzCommunications")
	private List<ClazzCommunication> outgoingClazzCommunications = new ArrayList<ClazzCommunication>();

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getFullQualifiedName() {
		return fullQualifiedName;
	}

	public void setFullQualifiedName(final String name) {
		this.fullQualifiedName = name;
	}

	public Set<Integer> getObjectIds() {
		return objectIds;
	}

	public void setObjectIds(final Set<Integer> objectIds) {
		this.objectIds = objectIds;
	}

	public Component getParent() {
		return parent;
	}

	public void setParent(final Component parent) {
		this.parent = parent;
	}

	public List<ClazzCommunication> getOutgoingClazzCommunications() {
		return outgoingClazzCommunications;
	}

	public void setOutgoingClazzCommunications(final List<ClazzCommunication> outgoingClazzCommunications) {
		this.outgoingClazzCommunications = outgoingClazzCommunications;
	}

	public void setInstanceCount(final int instanceCount) {
		this.instanceCount = instanceCount;
	}

	public int getInstanceCount() {
		return instanceCount;
	}

	/**
	 * Clears all existings communication within the clazz
	 */
	public void reset() {
		this.instanceCount = 0;
		this.getObjectIds().clear();

		// Do we need this bi-directional reset due to JSON API converter?
		this.getOutgoingClazzCommunications().forEach((outgoingClazz) -> {
			outgoingClazz.reset();
		});

		this.getOutgoingClazzCommunications().clear();
	}

}