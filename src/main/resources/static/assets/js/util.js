function makeDateStr(year, month, day, type){
    return year + '.' + ( (month < 10) ? '0' + month : month ) + '.' + ( (day < 10) ? '0' + day : day );
}
function makeTimeStr(hour, minute, second, type){
    return hour + ':' + ( (minute < 10) ? '0' + minute : minute ) + ':' + ( (second < 10) ? '0' + second : second );
}