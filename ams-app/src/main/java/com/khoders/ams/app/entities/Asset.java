package com.khoders.ams.app.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 *
 * @author 
 */
@Entity
@Table(name = "asset")
public class Asset extends UserAccountRecord implements Serializable
{
    
}
