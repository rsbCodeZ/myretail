myRetail RESTful service

This service enables user to ->
1. Get product and price information
2. Update price information

Details:
/myretail/* endpoints are service endpoints fpr myRetail
/product-api/* endpoints mock the product API which myRetail connects to fetch product info
/price-api/* endpoints mock the external price API which myRetail connects to fetch price info for a product

Only myRetail API endpoints are exposed via Swagger:
http://localhost:8080/swagger-ui.html#/web-controller
