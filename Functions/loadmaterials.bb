Function loadmaterials%(arg0$)
    Local local0$
    Local local1.materials
    Local local2$
    Local local3%
    local1 = Null
    local2 = ""
    local3 = openfile(arg0)
    While (eof(local3) = $00)
        local0 = trim(readline(local3))
        If (left(local0, $01) = "[") Then
            local0 = mid(local0, $02, (len(local0) - $02))
            local1 = (New materials)
            local1\Field0 = lower(local0)
            If (bumpenabled <> 0) Then
                local2 = scpmodding_processfilepath(getinistring(arg0, local0, "bump", ""))
                If (local2 <> "") Then
                    local1\Field2 = loadtexture_strict(local2, $01)
                    applybumpmap(local1\Field2)
                EndIf
            EndIf
            local1\Field3 = (getiniint(arg0, local0, "stepsound", $00) + $01)
        EndIf
    Wend
    closefile(local3)
    Return $00
End Function
