package service2;


import service1.ZodiacSign;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme Couto
 */
public class ChineseSignImpl extends UnicastRemoteObject implements ChineseSign{
    
    public ChineseSignImpl() throws RemoteException{
        super();
    }
    
    public String calculateSign(String ano) throws RemoteException{
        int year = Integer.parseInt(ano);
        if((year==1912) || (year==1924) || (year==1936) || (year==1948) || (year==1960) || (year==1972) || (year==1984) || (year==1996) || (year==2008))
            return "Rato";
        else if((year==1913) || (year==1925) || (year==1937) || (year==1949) || (year==1961) || (year==1973) || (year==1985) || (year==1997) || (year==2009))
            return "Boi";
        else if((year==1914) || (year==1926) || (year==1938) || (year==1950) || (year==1962) || (year==1974) || (year==1986) || (year==1998) || (year==2010))
            return "Tigre";
        else if((year==1915) || (year==1927) || (year==1939) || (year==1951) || (year==1963) || (year==1975) || (year==1987) || (year==1999) || (year==2011))
            return "Coelho";
        else if((year==1916) || (year==1928) || (year==1940) || (year==1952) || (year==1964) || (year==1976) || (year==1988) || (year==2000) || (year==2012))
            return "Dragao";
        else if((year==1917) || (year==1929) || (year==1941) || (year==1953) || (year==1965) || (year==1977) || (year==1989) || (year==2001) || (year==2013))
            return "Serpente";
        else if((year==1918) || (year==1930) || (year==1942) || (year==1954) || (year==1966) || (year==1978) || (year==1990) || (year==2002) || (year==2014))
            return "Cavalo";
        else if((year==1919) || (year==1931) || (year==1943) || (year==1955) || (year==1967) || (year==1979) || (year==1991) || (year==2003) || (year==2015))
            return "Cabra";
        else if((year==1920) || (year==1932) || (year==1944) || (year==1956) || (year==1968) || (year==1980) || (year==1992) || (year==2004) || (year==2016))
            return "Macaco";
        else if((year==1921) || (year==1933) || (year==1945) || (year==1957) || (year==1969) || (year==1981) || (year==1993) || (year==2005) || (year==2017))
            return "Galo";
        else if((year==1922) || (year==1934) || (year==1946) || (year==1958) || (year==1970) || (year==1982) || (year==1994) || (year==2006) || (year==2018))
            return "Cao";
        else if((year==1923) || (year==1935) || (year==1947) || (year==1959) || (year==1971) || (year==1983) || (year==1995) || (year==2007) || (year==2019))
            return "Porco";
        else 
        
        
        
        return "Signo não encontrado";
    }
    
}