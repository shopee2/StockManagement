package io.swagger.api;

import io.swagger.model.Category;
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
public class CategoryApiController implements CategoryApi {

    private static final Logger log = LoggerFactory.getLogger(CategoryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CategoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Category>> categoryGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Category>>(objectMapper.readValue("[ {  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : 0}, {  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : 0} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Category>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Category>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Long> categoryIdCountGet(@ApiParam(value = "ID of category to be counted",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Long>(objectMapper.readValue("0", Long.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Long>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Long>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> categoryIdDelete(@ApiParam(value = "ID of category to be deleted",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Category> categoryIdGet(@ApiParam(value = "ID of category",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Category>(objectMapper.readValue("{  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : 0}", Category.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Category>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> categoryIdPatch(@ApiParam(value = "ID of category to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Modified category object" ,required=true )  @Valid @RequestBody Category body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Product>> categoryIdProductsGet(@ApiParam(value = "ID of category to be listed",required=true) @PathVariable("id") Long id) {
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

    public ResponseEntity<Void> categoryIdPut(@ApiParam(value = "ID of category to be updated",required=true) @PathVariable("id") Long id,@ApiParam(value = "Modified category object" ,required=true )  @Valid @RequestBody Category body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> categoryPost(@ApiParam(value = "Category object that needs to be added" ,required=true )  @Valid @RequestBody Category body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
