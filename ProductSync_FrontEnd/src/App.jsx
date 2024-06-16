import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import AllItems from './pages/AllItems';
import UpdateItem from './pages/UpdateItem';
import DeleteItem from './pages/DeleteItem';
import SearchResults from './pages/SearchResults';
import CreateProduct from './pages/CreateProduct'; 

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<AllItems />} />
                <Route path="/update" element={<UpdateItem />} />
                <Route path="/delete" element={<DeleteItem />} />
                <Route path="/search/:searchTerm" element={<SearchResults />} />
                <Route path="/create" element={<CreateProduct />} />
            </Routes>
        </Router>
    );
};

export default App;
