package ru.zakharov.enterprise.service;

import ru.zakharov.enterprise.dto.ResultDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SimpleServiceSOAP {

    @WebMethod
    public ResultDTO ping() {
        return new ResultDTO();
    }
}
