import React from "react";
import SearchComponent from "../Components/SearchComponent"; // Ensure this path is correct
import "../Css/styles.css";
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
