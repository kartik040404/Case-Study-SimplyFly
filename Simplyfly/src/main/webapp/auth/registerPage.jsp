<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Sign Up — SimplyFly</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet"/>

  <style>
    :root {
      --sky-gradient: linear-gradient(135deg, #80deea 0%, #e0f7fa 100%);
      --logo-gradient: linear-gradient(-45deg, #43cea2, #185a9d, #f093fb, #f5576c);
    }

    body {
      margin: 0;
      height: 100vh;
      background: var(--sky-gradient);
      overflow: hidden;
      display: flex;
      align-items: center;
      justify-content: center;
      font-family: 'Segoe UI', sans-serif;
      position: relative;
    }

    .bg-animation {
      position: absolute;
      top: 0; left: 0;
      width: 100%; height: 100%;
      z-index: 1;
      overflow: hidden;
    }
    .cloud {
      position: absolute;
      background: rgba(255,255,255,0.7);
      border-radius: 50%;
      animation: float 30s linear infinite;
    }
    .cloud:before {
      content: '';
      position: absolute;
      background: rgba(255,255,255,0.7);
      border-radius: 50%;
    }
    .cloud1 {
      width: 150px; height: 50px; top: 25%; left: -200px;
      animation-delay: 0s;
    }
    .cloud1:before {
      width: 80px; height: 80px;
      top: -25px; left: 30px;
    }
    .cloud2 {
      width: 120px; height: 40px; top: 65%; left: -200px;
      animation-delay: 10s;
    }
    .cloud2:before {
      width: 60px; height: 60px;
      top: -20px; left: 20px;
    }
    @keyframes float {
      0%   { transform: translateX(0); }
      100% { transform: translateX(120vw); }
    }

    .plane-fly {
      position: absolute;
      font-size: 3rem;
      color: rgba(255,255,255,0.5);
      top: 70%; left: -10%;
      transform: rotate(-15deg);
      animation: fly 8s ease-in-out infinite;
      z-index: 1;
    }
    @keyframes fly {
      0%   { left: -10%; top: 70%; }
      50%  { left: 110%; top: 30%; }
      100% { left: -10%; top: 70%; }
    }

    .signup-card {
      position: relative;
      z-index: 2;
      background: rgba(255,255,255,0.95);
      border-radius: 20px;
      box-shadow: 0 20px 40px rgba(0,0,0,0.1);
      padding: 2rem;
      width: 90%;
      max-width: 600px;
      transition: transform 0.3s ease, box-shadow 0.3s ease;
      transform-style: preserve-3d;
    }
    .signup-card:hover {
      transform: rotateY(5deg) rotateX(3deg) translateZ(8px);
      box-shadow: 0 30px 60px rgba(0,0,0,0.15);
    }

    .brand-logo {
      font-size: 2.25rem;
      font-weight: bold;
      text-align: center;
      margin-bottom: 1rem;
      background: var(--logo-gradient);
      background-size: 400% 400%;
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      animation: logoShift 8s ease infinite;
    }
    @keyframes logoShift {
      0%,100% { background-position: 0%   50%; }
      50%     { background-position: 100% 50%; }
    }

    .form-label { color: #333; font-weight: 600; }
    .form-control {
      border-radius: 12px;
      padding: 0.75rem 1rem;
    }

    .btn-signup {
      background: linear-gradient(45deg,#43cea2,#185a9d);
      border: none;
      border-radius: 12px;
      padding: 0.75rem;
      font-size: 1rem;
      font-weight: 600;
      color: #fff;
      width: 100%;
      box-shadow: 0 5px 15px rgba(0,0,0,0.1);
      transition: transform 0.2s ease, box-shadow 0.2s ease;
    }
    .btn-signup:hover {
      transform: translateY(-2px);
      box-shadow: 0 8px 20px rgba(0,0,0,0.15);
    }

    .alert-danger, .alert-success {
      border-radius: 8px;
      font-size: 0.9rem;
    }

    .divider {
      text-align: center;
      margin: 1.2rem 0;
      position: relative;
      color: #555;
    }
    .divider:before, .divider:after {
      content: '';
      position: absolute;
      width: 35%;
      height: 1px;
      background: #ddd;
      top: 50%;
    }
    .divider:before { left: 5%; }
    .divider:after  { right: 5%; }
    .divider span {
      background: #fff;
      padding: 0 0.5rem;
      font-size: 0.85rem;
    }

    .login-link {
      color: #007bff;
      text-decoration: none;
      font-size: 0.9rem;
    }
    .login-link:hover { color: #0056b3; }
  </style>
</head>
<body>
  <div class="bg-animation">
    <div class="cloud cloud1"></div>
    <div class="cloud cloud2"></div>
  </div>
  <div class="plane-fly">
    <i class="fas fa-plane"></i>
  </div>

  <div class="signup-card">
    <div class="brand-logo">
      <i class="fas fa-plane me-1"></i>SimplyFly
    </div>
    <p class="text-center text-muted mb-3" style="font-size:0.9rem;">
      Create your passenger account
    </p>

    <c:if test="${not empty error}">
      <div class="alert alert-danger mb-3">
        <i class="fas fa-exclamation-circle me-1"></i>${error}
      </div>
    </c:if>
    <c:if test="${not empty msg}">
      <div class="alert alert-success mb-3">
        <i class="fas fa-check-circle me-1"></i>${msg}
      </div>
    </c:if>

    <form action="register" method="post">
      <div class="row g-3">
        <div class="col-md-6">
          <label for="name" class="form-label">Full Name</label>
          <input type="text" id="name" name="name" class="form-control" required>
        </div>
        <div class="col-md-6">
          <label for="email" class="form-label">Email</label>
          <input type="email" id="email" name="email" class="form-control" required>
        </div>
      </div>
      <div class="row g-3 mt-1">
        <div class="col-md-6">
          <label for="password" class="form-label">Password</label>
          <input type="password" id="password" name="password" class="form-control" required>
        </div>
        <div class="col-md-6">
          <label for="gender" class="form-label">Gender</label>
          <select id="gender" name="gender" class="form-select" required>
            <option value="" disabled selected>Choose…</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
          </select>
        </div>
      </div>
      <div class="row g-3 mt-1">
        <div class="col-md-6">
          <label for="contact" class="form-label">Contact Number</label>
          <input type="tel" id="contact" name="contactNumber" class="form-control">
        </div>
        <div class="col-md-6">
          <label for="address" class="form-label">Address</label>
          <textarea id="address" name="address" class="form-control" rows="1"></textarea>
        </div>
      </div>

      <button type="submit" class="btn btn-signup mt-4">
        <i class="fas fa-user-plus me-1"></i>Sign Up
      </button>
    </form>

    <div class="divider"><span>Already have an account?</span></div>
    <div class="text-center">
      <a href="login" class="login-link">
        <i class="fas fa-sign-in-alt me-1"></i>Log in here
      </a>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
