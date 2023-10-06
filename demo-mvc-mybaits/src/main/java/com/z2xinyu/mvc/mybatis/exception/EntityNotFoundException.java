package com.z2xinyu.mvc.mybatis.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Object not found") // 可以将异常映射为异常状态码
public class EntityNotFoundException extends RuntimeException{
    private long entityId;

    public EntityNotFoundException(long entityId) {
        this.entityId = entityId;
    }

    public long getEntityId() {
        return entityId;
    }
}
