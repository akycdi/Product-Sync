import React from "react";
import SearchComponent from "../Components/SearchComponent"; 
import "../CSS/AllItems.css";
import ProductList from "../Components/ProductList";

const Products = () => {
    return (
        <div className="all-items-container">
            <SearchComponent />
            <ProductList/>
        </div>
    );
};

export default Products;
