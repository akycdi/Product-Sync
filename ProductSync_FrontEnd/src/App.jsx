import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import AllItems from "./pages/AllItems";
import UpdateItem from "./pages/UpdateItem";
import DeleteItem from "./pages/DeleteItem";
import CreateProduct from "./pages/CreateProduct";
import ProductDetail from "./pages/ProductDetail";
import UpdateProduct from "./Components/UpdateProduct";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<AllItems />} />
        <Route path="/update" element={<UpdateItem />} />
        <Route path="/delete" element={<DeleteItem />} />
        <Route path="/create" element={<CreateProduct />} />
        <Route path="/product/:id" element={<ProductDetail />} />
        <Route path="/update-item" element={<UpdateItem />} />
        <Route path="/product/update/:id" element={<UpdateProduct />} />
      </Routes>
    </Router>
  );
};

export default App;
