package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.constants.ApiConstants;
import com.fon.knjizarafrontend.dto.StoreImageDTO;
import com.fon.knjizarafrontend.service.StoreImageService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class StoreImageServiceImpl implements StoreImageService {

    @Resource
    private RestTemplate restTemplate;

    private final String api = ApiConstants.storeImagesApi;

    @Override
    public ResponseEntity<Object> saveStoreImage(StoreImageDTO storeImageDTO) {
        return restTemplate.postForEntity(api, storeImageDTO, Object.class);
    }

    @Override
    public ResponseEntity<StoreImageDTO[]> findStoreImagesByStoreId(long storeId) {
        return restTemplate.getForEntity(api + "/" + storeId, StoreImageDTO[].class);
    }

    @Override
    public ResponseEntity<Object> deleteStoreImage(long imageId) {
        return restTemplate.exchange(api + "/" + imageId, HttpMethod.DELETE, null, Object.class);
    }
}
