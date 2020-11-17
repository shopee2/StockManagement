package io.swagger.api;

import java.util.List;
import io.swagger.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-17T06:22:14.703Z")

@Controller
public class ProductApiController implements ProductApi {

    private static final Logger log = LoggerFactory.getLogger(ProductApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> productDelete(@ApiParam(value = "IDs of products to be deleted" ,required=true )  @Valid @RequestBody List<Integer> body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Product>> productGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Product>>(objectMapper.readValue("[ {  \"price\" : 1.4658129,  \"imageUrl\" : \"imageUrl\",  \"name\" : \"name\",  \"description\" : \"description\",  \"weight\" : 6.0274563,  \"id\" : 0,  \"shopId\" : 5,  \"sku\" : \"sku\",  \"stock\" : 5,  \"categoryId\" : 2}, {  \"price\" : 1.4658129,  \"imageUrl\" : \"imageUrl\",  \"name\" : \"name\",  \"description\" : \"description\",  \"weight\" : 6.0274563,  \"id\" : 0,  \"shopId\" : 5,  \"sku\" : \"sku\",  \"stock\" : 5,  \"categoryId\" : 2} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Product>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> productIdDelete(@ApiParam(value = "ID of product to be deleted",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> productIdGet(@ApiParam(value = "ID of product",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{  \"price\" : 1.4658129,  \"imageUrl\" : \"imageUrl\",  \"name\" : \"name\",  \"description\" : \"description\",  \"weight\" : 6.0274563,  \"id\" : 0,  \"shopId\" : 5,  \"sku\" : \"sku\",  \"stock\" : 5,  \"categoryId\" : 2}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> productIdPatch(@ApiParam(value = "ID of product to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Modified product object" ,required=true )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> productIdPut(@ApiParam(value = "ID of product to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Modified product object" ,required=true )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> productPatch(@ApiParam(value = "Modified products array" ,required=true )  @Valid @RequestBody List<Product> body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> productPost(@ApiParam(value = "Product object that needs to be added" ,required=true )  @Valid @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
