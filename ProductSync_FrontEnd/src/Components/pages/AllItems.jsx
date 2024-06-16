import React, { useState, useEffect } from 'react';
import axios from 'axios';
import SearchComponent from '../components/SearchComponent';
import '../styles.css'; // Import the CSS file for styling

const AllItems = () => {
    // State and useEffect for fetching all items

    return (
        <div className="container">
            <h1 className="header">All Items</h1>
            <SearchComponent />
        </div>
    );
};

export default AllItems;
