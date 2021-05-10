package com.bridgelabz.censusanalyser;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
    public static final String INDIAN_STATE_CENSUS_FILE = "src\\main\\resources\\IndianStateCensusData.csv";
    public static final String INDIAN_STATE_CODE_FILE = "src\\main\\resources\\IndiaStateCode.csv";
    public static final String WRONG_CSV_FILE = "src\\main\\resources\\IndiaStateCode";
    public static final String WRONG_CSV_FILE_TYPE = "src\\main\\resources\\IndiaStateCensusData.txt";

    //UC-1
    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() {
        try {
            int count = CensusAnalyser.loadCensusData(INDIAN_STATE_CENSUS_FILE);
            Assert.assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    //TC - 1.1
    @Test
    public void givenIndianStateCodeCSVFile_ReturnsCorrectRecords() {
        try {
            int count = CensusAnalyser.loadCodeData(INDIAN_STATE_CODE_FILE);
            System.out.println(count);
            Assert.assertEquals(37, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    //TC - 1.2
    @Test
    public void givenIndiaStateCensusFile_WithIncorrectFile_ShouldThrowException() {
        try {
            CensusAnalyser.loadCensusData(WRONG_CSV_FILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    //TC - 1.3
    @Test
    public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser.loadWrongCensusData(WRONG_CSV_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE,e.type);
        }
    }
}