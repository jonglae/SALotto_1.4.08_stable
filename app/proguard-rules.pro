-optimizationpasses 5

  #When not preverifing in a case-insensitive filing system, such as Windows. Because this tool unpacks your processed jars, you should then use:
  -dontusemixedcaseclassnames

  #Specifies not to ignore non-public library classes. As of version 4.5, this is the default setting
  -dontskipnonpubliclibraryclasses

  #Preverification is irrelevant for the dex compiler and the Dalvik VM, so we can switch it off with the -dontpreverify option.
  -dontpreverify

  #Specifies to write out some more information during processing. If the program terminates with an exception, this option will print out the entire stack trace, instead of just the exception message.
  -verbose

  # Platform calls Class.forName on types which do not exist on Android to determine platform.
  -dontnote retrofit2.Platform
  # Platform used when running on Java 8 VMs. Will not be used at runtime.
  -dontwarn retrofit2.Platform$Java8
  # Retain generic type information for use by reflection by converters and adapters.
  -keepattributes Signature
  # Retain declared checked exceptions for use by a Proxy instance.
  -keepattributes Exceptions

  -dontwarn

  -optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
  -keep public class org.jsoup.** {
   	public *;
   }

   -ignorewarnings
#   -keep class * {
#       public private *;
#   }