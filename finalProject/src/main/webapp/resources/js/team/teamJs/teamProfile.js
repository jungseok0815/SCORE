init = () => {
    document.querySelector('.overview-tab').className += ' overview-tab-focused';
    
}

memberView = () => {
    document.querySelector('.overview-tab').classList.remove('overview-tab-focused');
    document.querySelector('.member-tab').className += ' member-tab-focused';
    document.querySelector('.team-overview').style.display = 'none';
    document.querySelector('.team-member').style.display = 'block';
}

overviewView = () => {
    document.querySelector('.member-tab').classList.remove('member-tab-focused');
    document.querySelector('.overview-tab').className += ' overview-tab-focused';
    document.querySelector('.team-overview').style.display = 'block';
    document.querySelector('.team-member').style.display = 'none';
}


