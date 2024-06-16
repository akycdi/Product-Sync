import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Products from "./pages/Products";
import CreateProduct from "./pages/CreateProduct";
import ProductDetail from "./pages/ProductDetail";
import UpdateProduct from "./Components/UpdateProduct";
import HomePage from "./pages/HomePage";


const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/products" element={<Products />} />
        <Route path="/create" element={<CreateProduct />} />
        <Route path="/product/:id" element={<ProductDetail />} />
        <Route path="/product/update/:id" element={<UpdateProduct />} />
      </Routes>
    </Router>
  );
};

export default App;
