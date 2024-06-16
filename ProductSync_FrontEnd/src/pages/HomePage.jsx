import React from 'react';
import { Link } from 'react-router-dom';
import { Typography, Button, Container, Grid } from '@mui/material'; 
import '../CSS/HomePage.css'; 

const HomePage = () => {
    return (
        <Container maxWidth="md" className="home-page-container">
            <Typography variant="h3" align="center" gutterBottom>
                Welcome to Inventory Management System
            </Typography>
            <Grid container spacing={2} justifyContent="center">
                <Grid item>
                    <Button component={Link} to="/products" variant="contained" color="primary">
                        View Products
                    </Button>
                </Grid>
                <Grid item>
                    <Button component={Link} to="/create" variant="contained" color="primary">
                        Create Product
                    </Button>
                {/* <Grid item>
                    <Button component={Link} to="/categories" variant="contained" color="primary">
                        View Categories
                    </Button>
                </Grid> */}
                </Grid>
                {/* <Grid item>
                    <Button component={Link} to="/create-category" variant="contained" color="primary">
                        Create Category
                    </Button>
                </Grid> */}
            </Grid>
        </Container>
    );
};

export default HomePage;
