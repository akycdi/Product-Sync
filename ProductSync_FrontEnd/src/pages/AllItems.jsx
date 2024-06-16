import React from "react";
import SearchComponent from "../Components/SearchComponent"; 
import "../CSS/styles.css";
import ProductList from "../Components/ProductList";

const AllItems = () => {
    return (
        <div className="all-items-container">
            <SearchComponent />
            <ProductList/>
        </div>
    );
};

export default AllItems;
