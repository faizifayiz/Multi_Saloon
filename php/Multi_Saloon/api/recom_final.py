
# coding: utf-8

# In[1]:


import numpy as np
import pandas as pd
from sklearn.metrics.pairwise import cosine_similarity
from matplotlib import pyplot as plt
from scipy.sparse import csr_matrix


# In[2]:


import mysql.connector


# In[3]:


#database connectivity
mydb = mysql.connector.connect(
  host="localhost",
  port='3306',
  user="root",
  password="",
  database="multi_saloon"
)


# In[4]:

#selcting places from database
cursor = mydb.cursor()
cursor.execute("SELECT id,shop_name,place FROM saloon_tbl")
result = cursor.fetchall()
cursor.close()
movies = pd.DataFrame(result,columns=['location_id','location_title','location_photo']).iloc[:,:-1]
movies


# In[5]:


movies.info()


# In[9]:

#sele ting rating from database
cursor = mydb.cursor()
cursor.execute("SELECT * FROM rating_tbl")
result = cursor.fetchall()
cursor.close()
ratings = pd.DataFrame(result,columns=['id','user_id','location_id','rating']).iloc[:,1:]
ratings


# In[10]:

#converting into required format..
ratings['user_id'] = ratings['user_id'].astype('int')
ratings['location_id'] = ratings['location_id'].astype('int')
ratings['rating'] = ratings['rating'].astype('float')


# In[11]:


ratings.info()


# In[9]:


"""# Load the ratings dataset
ratings = pd.read_csv('ratings.csv')
ratings.head()"""


# In[12]:


ratings.info()


# In[13]:
print(ratings)


final_dataset = ratings.pivot(index='location_id',columns='user_id',values='rating')
final_dataset.head()


# In[14]:


final_dataset.fillna(0,inplace=True)
final_dataset.head()


# In[15]:


csr_data = csr_matrix(final_dataset.values)
final_dataset.reset_index(inplace=True)


# In[16]:


from sklearn.neighbors import NearestNeighbors
knn = NearestNeighbors(metric='cosine', algorithm='brute', n_neighbors=20, n_jobs=-1)
knn.fit(csr_data)


# In[7]:


"""# Load the ratings dataset
movies = pd.read_csv('location.csv')
movies.head()"""


# In[41]:


def get_movie_recommendation(movie_name):
    n_movies_to_reccomend = 10
    movie_list = movies[movies['location_title'].str.contains(movie_name)]  
    if len(movie_list):        
        movie_idx= movie_list.iloc[0]['location_id']
        movie_idx = final_dataset[final_dataset['location_id'] == movie_idx].index[0]
        distances , indices = knn.kneighbors(csr_data[movie_idx],n_neighbors=n_movies_to_reccomend+1)    
        rec_movie_indices = sorted(list(zip(indices.squeeze().tolist(),distances.squeeze().tolist())),key=lambda x: x[1])[:0:-1]
        recommend_frame = []
        for val in rec_movie_indices:
            movie_idx = final_dataset.iloc[val[0]]['location_id']
            idx = movies[movies['location_id'] == movie_idx].index
            try:
                recommend_frame.append({'location_title':movies.iloc[idx]['location_title'].values[0],'Distance':val[1],'location_id':movies.iloc[idx]['location_id'].values[0]})
            except:
                pass
        try:
            df = pd.DataFrame(recommend_frame,index=range(1,n_movies_to_reccomend+1))
        except:
            df = pd.DataFrame(recommend_frame,index=range(1,n_movies_to_reccomend))
        return df
    else:
        return "No movies found. Please check your input"


# In[42]:

if __name__ == '__main__':

    file=open("input.txt","r")
    loc=file.read()
    file.close()


    recommendation=get_movie_recommendation(loc)

    data=list()
    for index, row in recommendation.iterrows():
        temp=dict()
        temp={"id":row["location_id"]}
        data.append(temp)
    datas={'data':data}


    #print(datas)
    print(list(recommendation['location_id']))
    file=open("result.txt","w")
    file.write(str(list(recommendation['location_id'])))
    file.close()


    # In[43]:


    #print(list(recommendation['location_title']))


    # In[44]:


    

