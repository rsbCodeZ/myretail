myRetail RESTful service

This service enables user to ->
1. Get product and price information
2. Update price information

Details:
1. /myretail/* endpoints are service endpoints fpr myRetail
2. /product-api/* endpoints mock the product API which myRetail connects to fetch product info
3. /price-api/* endpoints mock the external price API which myRetail connects to fetch price info for a product

Only myRetail API endpoints are exposed via Swagger:
http://localhost:8080/swagger-ui.html#/web-controller
