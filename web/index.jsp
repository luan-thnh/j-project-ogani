<%@page import="connectDB.DbCon"%>
<%@page import="dao.ProductDao"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth);
    }
    ProductDao pd = new ProductDao(DbCon.getConnection());
    List<Product> products = pd.getAllProducts();

    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        ProductDao pDao = new ProductDao(DbCon.getConnection());
        double total = pDao.getTotalCartPrice(cart_list);
        request.setAttribute("total", total);
        request.setAttribute("cart_list", cart_list);
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/head.jsp"%>
        <title>Ogani | Trang Chủ</title>
    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>
        <%@include file="/includes/hero.jsp"%>
        <%@include file="/includes/categories.jsp"%>

        <!-- Featured Section Begin -->
        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Featured Product</h2>
                        </div>
                        <div class="featured__controls">
                            <ul>
                                <li class="active" data-filter="*">All</li>
                                <li data-filter=".oranges">Oranges</li>
                                <li data-filter=".fresh-meat">Fresh Meat</li>
                                <li data-filter=".vegetables">Vegetables</li>
                                <li data-filter=".fastfood">Fastfood</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row featured__filter">
                    <%if (!products.isEmpty()) {
                            for (Product product : products) {
                    %>
                    <div class="col-lg-3 col-md-4 col-sm-6 mix <%=product.getCombinedCategories()%>">
                        <div class="featured__item">
                            <div class="featured__item__pic set-bg" data-setbg="<%=product.getThumbnail()%>">
                                <ul class="featured__item__pic__hover">
                                    <!--                                    <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-retweet"></i></a></li>-->
                                    <li><a href="add-to-cart?id=<%=product.getId()%>"><i class="fa fa-shopping-cart"></i></a></li>
                                </ul>
                            </div>
                            <div class="featured__item__text">
                                <h6><a href="#"><%=product.getTitle()%></a></h6>
                                <h5>$<%=product.getPrice()%></h5>
                            </div>
                        </div>
                    </div>
                    <%
                            }
                        } else {
                            out.println("There is no proucts");
                        }
                    %>
                </div>
            </div>
        </section>
        <!-- Featured Section End -->

        <%@include file="/includes/footer.jsp"%>
    </body>
</html>