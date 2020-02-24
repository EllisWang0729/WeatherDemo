package com.example.weatherdemo;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Parameter;
import java.util.List;

public class CityWeatherData {
    private String success;
    private Records records;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }

    static class Records {
        private String datasetDescription;
        private List<LocationData> location;

        public String getDatasetDescription() {
            return datasetDescription;
        }

        public void setDatasetDescription(String datasetDescription) {
            this.datasetDescription = datasetDescription;
        }

        public List<LocationData> getLocation() {
            return location;
        }

        public void setLocation(List<LocationData> location) {
            this.location = location;
        }

        public static class LocationData implements Parcelable {
            private String locationName;
            private List<WeatherElement> weatherElement;


            protected LocationData(Parcel in) {
                locationName = in.readString();
                weatherElement = in.createTypedArrayList(WeatherElement.CREATOR);
            }

            public static final Creator<LocationData> CREATOR = new Creator<LocationData>() {
                @Override
                public LocationData createFromParcel(Parcel in) {
                    return new LocationData(in);
                }

                @Override
                public LocationData[] newArray(int size) {
                    return new LocationData[size];
                }
            };

            public String getLocationName() {
                return locationName;
            }

            public void setLocationName(String locationName) {
                this.locationName = locationName;
            }

            public List<WeatherElement> getWeatherElement() {
                return weatherElement;
            }

            public void setWeatherElement(List<WeatherElement> weatherElement) {
                this.weatherElement = weatherElement;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(locationName);
                parcel.writeTypedList(weatherElement);
            }


            public static class WeatherElement implements Parcelable{
                private String elementName;
                private List<Time> time;


                protected WeatherElement(Parcel in) {
                    elementName = in.readString();
                    time = in.createTypedArrayList(Time.CREATOR);
                }

                public static final Creator<WeatherElement> CREATOR = new Creator<WeatherElement>() {
                    @Override
                    public WeatherElement createFromParcel(Parcel in) {
                        return new WeatherElement(in);
                    }

                    @Override
                    public WeatherElement[] newArray(int size) {
                        return new WeatherElement[size];
                    }
                };

                public String getElementName() {
                    return elementName;
                }

                public void setElementName(String elementName) {
                    this.elementName = elementName;
                }

                public List<Time> getTime() {
                    return time;
                }

                public void setTime(List<Time> time) {
                    this.time = time;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(elementName);
                    parcel.writeTypedList(time);
                }


                public static class Time implements Parcelable{
                    private String startTime;
                    private String endTime;
                    private Parameter parameter;


                    protected Time(Parcel in) {
                        startTime = in.readString();
                        endTime = in.readString();
                        parameter = in.readParcelable(Parameter.class.getClassLoader());
                    }

                    public static final Creator<Time> CREATOR = new Creator<Time>() {
                        @Override
                        public Time createFromParcel(Parcel in) {
                            return new Time(in);
                        }

                        @Override
                        public Time[] newArray(int size) {
                            return new Time[size];
                        }
                    };

                    public Parameter getParameter() {
                        return parameter;
                    }

                    public void setParameter(Parameter parameter) {
                        this.parameter = parameter;
                    }

                    public String getStartTime() {
                        return startTime;
                    }

                    public void setStartTime(String startTime) {
                        this.startTime = startTime;
                    }

                    public String getEndTime() {
                        return endTime;
                    }

                    public void setEndTime(String endTime) {
                        this.endTime = endTime;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel parcel, int i) {
                        parcel.writeString(startTime);
                        parcel.writeString(endTime);
                        parcel.writeParcelable(parameter, i);
                    }


                    public static class Parameter implements Parcelable{
                        private String parameterName;
                        private String parameterUnit;

                        protected Parameter(Parcel in) {
                            parameterName = in.readString();
                            parameterUnit = in.readString();
                        }

                        @Override
                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeString(parameterName);
                            dest.writeString(parameterUnit);
                        }

                        @Override
                        public int describeContents() {
                            return 0;
                        }

                        public static final Creator<Parameter> CREATOR = new Creator<Parameter>() {
                            @Override
                            public Parameter createFromParcel(Parcel in) {
                                return new Parameter(in);
                            }

                            @Override
                            public Parameter[] newArray(int size) {
                                return new Parameter[size];
                            }
                        };

                        public String getParameterName() {
                            return parameterName;
                        }

                        public void setParameterName(String parameterName) {
                            this.parameterName = parameterName;
                        }

                        public String getParameterUnit() {
                            return parameterUnit;
                        }

                        public void setParameterUnit(String parameterUnit) {
                            this.parameterUnit = parameterUnit;
                        }
                    }
                }
            }
        }
    }

}
