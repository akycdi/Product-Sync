import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../CSS/SearchComponent.css';

const SearchComponent = () => {
    const [searchTerm, setSearchTerm] = useState('');
    const navigate = useNavigate();

    const handleSearch = () => {
        navigate(`/search/${searchTerm}`);
    };

    return (
        <div className="search-container">
            <h1>Product Search</h1>
            <input
                type="text"
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                placeholder="Search by name..."
            />
            <button onClick={handleSearch}>Search</button>
        </div>
    );
};

export default SearchComponent;
