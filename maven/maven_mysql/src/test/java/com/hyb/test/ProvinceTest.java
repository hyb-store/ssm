package com.hyb.test;

import com.hyb.dao.impl.ProvinceDaoImpl;
import com.hyb.domain.Province;
import org.junit.Test;


import java.util.List;

public class ProvinceTest {

    @Test
    public void findAll() throws Exception {
        ProvinceDaoImpl pdi = new ProvinceDaoImpl();
        List<Province> all = pdi.findAll();

        for (Province province : all) {
            System.out.println(province.id+":"+province.getName());
        }
    }
}
