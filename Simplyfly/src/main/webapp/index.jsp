<%@ page contentType="text/html; charset=UTF-8" language="java" session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>SimplyFly — Welcome</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap & FontAwesome -->
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"/>
  <link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    rel="stylesheet"/>

  <style>
    :root {
      --sky-gradient: linear-gradient(135deg, #80deea 0%, #e0f7fa 100%);
      --cta-gradient: linear-gradient(45deg, #667eea, #764ba2);
    }
    body, html {
      height: 100%;
      margin: 0;
      font-family: 'Segoe UI', sans-serif;
      background: var(--sky-gradient);
    }
    .hero {
      height: 100%;
      display: flex;
      align-items: center;
      justify-content: center;
      text-align: center;
      position: relative;
      overflow: hidden;
    }
    .hero-content {
      z-index: 2;
      max-width: 600px;
    }
    .hero h1 {
      font-size: 3rem;
      margin-bottom: 1rem;
      color: #333;
      font-weight: bold;
    }
    .hero p {
      font-size: 1.25rem;
      color: #555;
      margin-bottom: 2rem;
    }
    .btn-cta {
      padding: 0.75rem 2rem;
      font-size: 1.1rem;
      font-weight: 600;
      color: #fff;
      border: none;
      border-radius: 8px;
      background: var(--cta-gradient);
      margin: 0 0.5rem;
      transition: transform .2s, box-shadow .2s;
    }
    .btn-cta:hover {
      transform: translateY(-3px);
      box-shadow: 0 8px 20px rgba(0,0,0,0.15);
    }
    /* drifting clouds */
    .cloud {
      position: absolute;
      background: rgba(255,255,255,0.7);
      border-radius: 50%;
      animation: float 40s linear infinite;
    }
    .cloud.small  { width:120px; height:40px; top:20%;  left:-150px; animation-delay:0s; }
    .cloud.medium { width:160px; height:50px; top:60%;  left:-200px; animation-delay:10s; }
    .cloud.large  { width:200px; height:60px; top:40%;  left:-250px; animation-delay:20s; }
    .cloud:before {
      content: ''; position:absolute;
      background: rgba(255,255,255,0.7);
      border-radius:50%;
    }
    .cloud.small:before  { width:60px;  height:60px;  top:-25px; left:20px; }
    .cloud.medium:before { width:80px;  height:80px;  top:-30px; left:30px; }
    .cloud.large:before  { width:100px; height:100px; top:-35px; left:40px; }
    @keyframes float {
      0%   { transform: translateX(0); }
      100% { transform: translateX(120vw); }
    }
    /* swooping plane */
    .plane {
      position: absolute;
      font-size: 4rem;
      color: rgba(255,255,255,0.5);
      top: 80%; left: -10%;
      transform: rotate(-15deg);
      animation: fly 12s ease-in-out infinite;
    }
    @keyframes fly {
      0%   { left:-10%;  top:80%; }
      50%  { left:110%;  top:20%; }
      100% { left:-10%;  top:80%; }
    }
  </style>
</head>
<body>

  <div class="hero">
    <!-- Animated background elements -->
    <div class="cloud small"></div>
    <div class="cloud medium"></div>
    <div class="cloud large"></div>
    <div class="plane"><i class="fas fa-plane"></i></div>

    <!-- Hero content -->
    <div class="hero-content">
      <h1>Welcome to SimplyFly</h1>
      <p>Book your next flight in seconds. Fast, secure, and hassle-free.</p>
      <a href="login" class="btn btn-cta">
        <i class="fas fa-sign-in-alt me-2"></i>Login
      </a>
      <a href="register" class="btn btn-cta">
        <i class="fas fa-user-plus me-2"></i>Sign Up
      </a>
    </div>
  </div>

  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
  </script>
</body>
</html>
