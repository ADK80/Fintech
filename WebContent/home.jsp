<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FEF - Home</title>
<%@ include file="header.jsp" %>
</head>
<body>

<%@ include file="menu.jsp" %>
	    <!-- Conteúdo 1 -->
    <div class="container">
      <div class="row my-4">
        <div class="col-12 col-sm-12 col-md-6 col-lg-3">
          <div class="col-12 mx-md-auto llogo">
            <a href="home.jsp"><img src="resources/images/logo.png" alt="logo" class="img-fluid mx-auto d-block"></a>
          </div>
        </div>
        <div class="col-12 col-sm-12 col-md-6 col-lg-9">
          <div class="col-12 p-4 myfont text-center">
            <h1 class="display-1"><p>Suas <font color="003c43">Finanças</font><p><font color="002086">Simples</font> assim</p></h1>
          </div>
        </div>
      </div>
    </div>
    <!-- Conteúdos inferiores -->
    <div class="container text-center mb-4">
        <div class="row">
          <div class="col-12 col-sm-12 col-md-6 col-lg-3 p-3 text-left transparent">
            <div class="col-12 text-center bg-light rounded-3 p-3 shadow myeffect fixheight" onclick="location.href='cadastro-usuario.jsp';">
              <img src="resources/images/1.png" alt="logo"><p><h2>Cadastre-se</h2></p><p>Área para você começar a descomplicar a sua vida.</p>
            </div>
          </div>
          <div class="col-12 col-sm-12 col-md-6 col-lg-3 p-3 text-center transparent">
            <div class="col-12 text-center bg-light rounded-3 p-3 shadow myeffect fixheight" onclick="location.href='quemsomos.jsp';">
              <img src="resources/images/2.png" alt="logo"><p><h2>Quem somos</h2></p><p>Veja como foi a idéia e o porquê de decidirmos desenvolver o FEF.</p>
            </div>
          </div>
          <div class="col-12 col-sm-12 col-md-6 col-lg-3 p-3 text-center transparent">
            <div class="col-12 text-center bg-light rounded-3 p-3 shadow myeffect fixheight" onclick="location.href='faq.jsp';">
              <img src="resources/images/3.png" alt="logo"><p><h2>FAQ</h2></p><p>Respostas para as perguntas mais comuns.</p>
            </div>
          </div>
          <div class="col-12 col-sm-12 col-md-6 col-lg-3 p-3 text-center transparent">
            <div class="col-12 text-center bg-light rounded-3 p-3 shadow myeffect fixheight" onclick="location.href='linksuteis.jsp';">
              <img src="resources/images/4.png" alt="logo"><p><h2>Links úteis</h2></p><p>Coletâneas de links muito úteis para você se manter informado.</p>
            </div>
          </div>
        </div>
      </div>

           <%@ include file="footer.jsp" %>
</body>
</html>