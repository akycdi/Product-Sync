import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import AllItems from './pages/AllItems';
import UpdateItem from './pages/UpdateItem';
import DeleteItem from './pages/DeleteItem';

const App = () => {
    return (
        <Router>
            <Switch>
                <Route path="/" exact component={AllItems} />
                <Route path="/update" exact component={UpdateItem} />
                <Route path="/delete" exact component={DeleteItem} />
            </Switch>
        </Router>
    );
};

export default App;
