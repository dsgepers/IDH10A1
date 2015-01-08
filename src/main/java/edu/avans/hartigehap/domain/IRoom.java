package edu.avans.hartigehap.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Created by panda on 18-12-14.
 */

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public abstract class IRoom extends DomainObject {
	
}