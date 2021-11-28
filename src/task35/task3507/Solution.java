package task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/*
ClassLoader - что это такое?
*/

public class Solution {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {


        String path = Paths.get("out/production/level30/" + Solution.class.getPackage().getName().replaceAll("[.]", "/")
                + "/data").toAbsolutePath().toString();


        Set<? extends Animal> allAnimals =
                getAllAnimals(path);
        System.out.println(allAnimals);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        String pathToClasses = "c:\\Users\\Андрей\\IdeaProjects\\level30\\out\\production\\level30\\task35\\task3501\\";
        Set<?> anotherClasses = getAnotherClasses(pathToClasses);
        for (Object o : anotherClasses) {
            Class cl = o.getClass();
            for (Method m : cl.getDeclaredMethods()) {
                if (m.getName().equals("main")) {
                    try {
                        m.invoke(null, (Object) args);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

            }
        }




    }



    public static Set<Object> getAnotherClasses(String pathToClasses) {

           Set<Object> result = new HashSet();
           File dir = new File(pathToClasses);
           String[] paths = dir.list(new FilenameFilter() {
               @Override
               public boolean accept(File dir, String name) {
                   return name.toLowerCase().endsWith(".class");
               }
           });

           for (String p : paths) {
               SimpleClassLoader simpleClassLoader = new SimpleClassLoader(pathToClasses);
               String className = p.substring(0, p.length() - 6);
               Class clazz = null;
               try {
                   clazz = simpleClassLoader.loadClass(className);
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               }


               try {
                   result.add((Object) clazz.newInstance());
               } catch (InstantiationException e) {
                   e.printStackTrace();
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               }
           }
           return result;
    }




    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + "\\";
        File dir = new File(pathToAnimals);
        String[] pathes = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir1, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });
        for (String p : pathes) {
            try {
                final String finalPathToAnimals = pathToAnimals;
                boolean hasInterface = false;
                boolean hasConstructor = false;

                ClassLoader loader = new ClassLoader() {
                    @Override
                    public Class<?> findClass(String className) throws ClassNotFoundException {
                        try {
                            byte[] b = fetchClassFromFS(finalPathToAnimals + className + ".class");
                            return defineClass(null, b, 0, b.length);
                        } catch (FileNotFoundException ex) {
                            return super.findClass(className);
                        } catch (IOException ex) {
                            return super.findClass(className);
                        }
                    }
                };
                String className = p.substring(0, p.length() - 6);
                Class clazz = loader.loadClass(className);

                Class[] interfaces = clazz.getInterfaces();
                for (Class i : interfaces) {
                    if (Animal.class == i) {
                        hasInterface = true;
                        break;
                    }
                }
                if (!hasInterface) continue;

                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors) {
                    if (c.getParameterTypes().length == 0) {
                        hasConstructor = true;
                        break;
                    }
                }
                if (!hasConstructor) continue;
                result.add((Animal) clazz.newInstance());
            } catch (Exception e) {
            }
        }
        return result;
    }


    private static byte[] fetchClassFromFS(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        // Get the size of the file
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}




