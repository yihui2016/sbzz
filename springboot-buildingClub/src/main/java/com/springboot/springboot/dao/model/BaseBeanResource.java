package com.springboot.springboot.dao.model;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * The "general" resource, i.e. any entity or value object
 * Like address, user, etc.
 * The class is *ONLY* intent to be inherit by Value object and Resource(Entity) itself.
 */
@MappedSuperclass
public abstract class BaseBeanResource {

	private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BaseBeanResource() {
    }

    /**
     * 使用对象的新值来更新旧的对象的对应字段的数值。
     * 仅仅非空字段被更新
     *
     * @param newVal
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */

    public void updateWithNewValue(Object newVal) throws IllegalArgumentException, IllegalAccessException {
        if (this.getClass() != newVal.getClass()) throw new IllegalArgumentException();
        Class c = this.getClass();
        while (!c.equals(BaseBeanResource.class)) {
            for (Field f : c.getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(newVal) != null) {
                    if (f.getDeclaredAnnotation(AcceptNewValue.class) != null)
                        f.set(this, f.get(newVal));
                }
            }
            c = c.getSuperclass();
        }
    }
}
