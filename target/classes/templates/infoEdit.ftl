<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<div class="container">
Personal information:
<form action="/${user.id}-${user.username}-edit" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Name: </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="name" value="${customers.name}" />
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Surname:</label>
            <div class="col-sm-6">
               <input class="form-control" type="text" name="surname" value="${customers.surname}" />
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">INN:</label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="inn" value="${customers.inn}" />
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Age:</label>
            <div class="col-sm-6">
               <input class="form-control" type="number" name="age" value="${coef.age}" />
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Sex:</label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="sex" value="${coef.sex}" />
            </div>
        </div>

<p>Having Bank Account: <input class="ml-3" type="radio" name="bankAccount" value="true"} />Yes  <input class="ml-3" type="radio" name="bankAccount" value="false" />No
<p>Having Property: <input class="ml-5" type="radio" name="property" value="true" />Yes <input class="ml-3" type="radio" name="property" value="false" />No

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Profession Name:</label>
            <div class="col-sm-6">
                 <input class="form-control" type="text" name="professionName" value="${profession.nameProfession}" />
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Profession District (Community, Non-community):</label>
            <div class="col-sm-6">
                 <input class="form-control" type="text" name="professionDistrict" value="${profession.professionDistrict}" />
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Profession Risk (Low, High, Other):</label>
            <div class="col-sm-6">
                 <input class="form-control" type="text" name="professionRisk" value="${profession.professionRisk}" />
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Experience, years:</label>
            <div class="col-sm-6">
                  <input class="form-control" type="number" name="experience" value="${profession.experience}" />
            </div>
        </div>


<input type="hidden" value="${_csrf.token}" name="_csrf">
<p><button class="btn btn-primary" type="submit">Save</button>
</form>

</div>
</@c.page>